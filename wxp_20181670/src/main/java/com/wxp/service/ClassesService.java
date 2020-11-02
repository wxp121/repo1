package com.wxp.service;

import com.wxp.pojo.Classes;

import java.util.List;

public interface ClassesService {

    /*查询所有班级*/
    List<Classes> QueryAll();

    /*根据ID查询班级*/
    Classes QueryOne(Integer class_id);

}
