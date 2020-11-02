package com.wxp.mapper;

import com.wxp.pojo.Teacher;
import com.wxp.pojo.TeacherVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TeacherMapper {

    /*添加教师*/
    int insert(Teacher teacher);

    /*修改教师*/
    int Update(Teacher teacher);

    /*删除教师*/
    int Delete(Integer teacher_id);

    /*查询所有教师*/
    List<TeacherVo> QueryAll();

    /*根据ID查询教师*/
    Teacher QueryOne(Integer teacher_id);
}
