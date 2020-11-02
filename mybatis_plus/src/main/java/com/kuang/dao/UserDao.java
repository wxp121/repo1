package com.kuang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 19:15:32
 */
@Mapper
public interface UserDao extends BaseMapper<User> {



}