package com.aaa.service;


import com.aaa.pojo.LoginUser;
import com.aaa.pojo.ResourceVo;
import com.aaa.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    //查询登录用户
    LoginUser selectByNamePwd(LoginUser user);

    //查询登录用户获得的角色
    List<Role> selectRolesByLoginId(Integer loginId);

    //查询登录用户对应的功能
    List<ResourceVo> selectResourcesByLoginId(Integer loginId);

    //根据用户名获取用户信息
    LoginUser selectByName(String username);

    //修改密码
    int changePassword(String username, String pwd);
}
