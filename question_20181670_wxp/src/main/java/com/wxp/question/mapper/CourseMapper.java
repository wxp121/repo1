package com.wxp.question.mapper;

import com.wxp.question.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CourseMapper {
    /*查询所有信息*/
    List<Course> QueryAll();
}
