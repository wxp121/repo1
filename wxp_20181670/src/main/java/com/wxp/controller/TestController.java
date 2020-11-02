package com.wxp.controller;


import com.alibaba.fastjson.JSON;
import com.wxp.pojo.Classes;
import com.wxp.pojo.Teacher;
import com.wxp.pojo.TeacherVo;
import com.wxp.service.ClassesService;
import com.wxp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/demo")
public class TestController {

    @Autowired
    TeacherService TeacherService;

    @Autowired
    ClassesService ClassesService;

    /*查询所有*/
    @RequestMapping("/Teacher")
    public String Teacher(Model model){
        List<TeacherVo> teacherVos = TeacherService.QueryAll();
        model.addAttribute("teachers",teacherVos);
        return "Teacher";
    }

    /*修改*/
    @GetMapping("/toUpdate/{teacher_id}")
    public String Teacher(@PathVariable Integer teacher_id,Model model){
        Teacher teacher = TeacherService.QueryOne(teacher_id);
        List<Classes> classes = ClassesService.QueryAll();
        model.addAttribute("teacher",teacher);
        model.addAttribute("classes",classes);
        return "UpdateTeacher";
    }

    @PutMapping("/doUpdate")
    public String Teacher(Teacher teacher){
        int update = TeacherService.Update(teacher);
        return "redirect:/demo/Teacher";
    }

    /*添加*/
    @GetMapping("/toAdd")
    public String doAdd(Model model){
        List<Classes> classes = ClassesService.QueryAll();
        model.addAttribute("classes",classes);
        return "AddTeacher";
    }

    @PostMapping("/doAdd")
    public String toAdd(Teacher teacher){
        TeacherService.insert(teacher);
        return "redirect:/demo/Teacher";
    }


    /*删除*/
    @GetMapping("/doDelete/{teacher_id}")
    public String doAdd(@PathVariable Integer teacher_id){
        TeacherService.Delete(teacher_id);
        return "redirect:/demo/Teacher";
    }

    @PostMapping("/doUpload")
    @ResponseBody
    public void doUpload(MultipartFile photo, HttpServletResponse resp) throws IOException {
        //定义真实的上传路径
        String realPath = "D:"+ File.separator+"photoimg";
        //访问路径
        String visitPath = "/photo"+File.separator;
        resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Map<String,String> result = new HashMap<>();
        //判断是否为空
        if(null ==photo){
            result.put("type","error");
            result.put("msg","请选择上传的图片");
            out.print(JSON.toJSONString(result));
            return;
        }
        //判断大小
        long size = photo.getSize();
        if(size > 2000000){
            result.put("type","error");
            result.put("msg","上传的图片超过限定大小，请上传2M以内的图片！");
            out.print(JSON.toJSONString(result));
            return;
        }
        //拿到图片的后缀
        int index = photo.getOriginalFilename().lastIndexOf(".");
        String suffix = photo.getOriginalFilename().substring(index);
        //判断后缀是否是图片
        if(!".jpg,.jpeg,.pgn,.gif".toUpperCase().contains(suffix.toUpperCase())){
            result.put("type","error");
            result.put("msg","必须上传指定格式的图片.jpg,.jpeg,.pgn,.gif");
            out.print(JSON.toJSONString(result));
            return;
        }
        //修改文件的名字
        String newFileName = System.currentTimeMillis()+""+suffix;
        //建立文件
        File file = new File(realPath,newFileName);
        //写入磁盘
        photo.transferTo(file);//把文件写入到指定的路径中；
        //返回给前端数据
        result.put("type","success");
        result.put("msg","上传成功！");
        result.put("fileName",newFileName);
        result.put("filePath",visitPath);
        out.print(JSON.toJSONString(result));
    }
}
