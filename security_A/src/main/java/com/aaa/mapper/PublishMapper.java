package com.aaa.mapper;




import com.aaa.pojo.Publish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface PublishMapper {
    int insert(Publish record);

    List<Publish> selectAll();
}