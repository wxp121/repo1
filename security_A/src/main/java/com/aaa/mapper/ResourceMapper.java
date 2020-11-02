package com.aaa.mapper;

import com.aaa.pojo.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface ResourceMapper {
    int insert(Resource record);

    List<Resource> selectAll();

    //根据登录用户的id查找到该用户对应的功能
    List<Resource> selectByLoginId(Integer loginId);

    //根据父级别编号查找对应的子菜单
    List<Resource> selectByFId(@Param("parentId") Integer parentId, @Param("ids") List<Integer> ids);

    //根据角色查找所有的资源
    List<Resource> selectByRoleId(Integer roleId);
}