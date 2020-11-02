package com.wxp.question.mapper;

import com.wxp.question.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface QuestionMapper {
    /*修改教师*/
    int Update(Question question);

    /*删除教师*/
    int Delete(Integer id);
}
