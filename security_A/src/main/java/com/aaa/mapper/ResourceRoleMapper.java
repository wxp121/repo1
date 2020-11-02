package com.aaa.mapper;

import com.aaa.pojo.ResourceRole;

import java.util.List;

public interface ResourceRoleMapper {
    int insert(ResourceRole record);

    List<ResourceRole> selectAll();
}