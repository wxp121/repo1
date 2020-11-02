package com.aaa.mapper;

import com.aaa.pojo.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    List<UserRole> selectAll();
}