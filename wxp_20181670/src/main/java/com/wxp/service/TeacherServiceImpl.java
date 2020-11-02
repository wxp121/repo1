package com.wxp.service;

import com.wxp.mapper.TeacherMapper;
import com.wxp.pojo.Teacher;
import com.wxp.pojo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int Update(Teacher teacher) {
        return teacherMapper.Update(teacher);
    }

    @Override
    public int Delete(Integer teacher_id) {
        return teacherMapper.Delete(teacher_id);
    }

    @Override
    public List<TeacherVo> QueryAll() {
        return teacherMapper.QueryAll();
    }

    @Override
    public Teacher QueryOne(Integer teacher_id) {
        return teacherMapper.QueryOne(teacher_id);
    }
}
