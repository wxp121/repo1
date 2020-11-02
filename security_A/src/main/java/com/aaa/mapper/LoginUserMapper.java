package com.aaa.mapper;

import com.aaa.pojo.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface LoginUserMapper {
    //添加登录账号
    int insert(LoginUser record);
    //查询所有的账号
    List<LoginUser> selectAll();
    //根据用户名密码查询账号
    LoginUser selectByNamePwd(LoginUser user);

    //根据用户名找到用户
    LoginUser selectByName(String username);

    //根据用户名修改密码
    int updatePwd(@Param("username") String username, @Param("pwd") String pwd);
}