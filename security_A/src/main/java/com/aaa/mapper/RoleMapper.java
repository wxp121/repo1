package com.aaa.mapper;

import com.aaa.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface RoleMapper {
    int insert(Role record);

    List<Role> selectAll();

    //根据登录账号找到对应的角色
    List<Role> selectByLoginId(Integer loginId);
}