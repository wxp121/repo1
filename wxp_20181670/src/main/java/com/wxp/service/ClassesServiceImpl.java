package com.wxp.service;

import com.wxp.mapper.ClassesMapper;
import com.wxp.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClassesService")
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    ClassesMapper classesMapper;

    @Override
    public List<Classes> QueryAll() {
        return classesMapper.QueryAll();
    }

    @Override
    public Classes QueryOne(Integer class_id) {
        return classesMapper.QueryOne(class_id);
    }
}
