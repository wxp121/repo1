package com.wxp.mapper;

import com.wxp.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ClassesMapper {

    /*查询所有班级*/
    List<Classes> QueryAll();

    /*根据ID查询班级*/
    Classes QueryOne(Integer class_id);
}
