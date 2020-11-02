package com.aaa.service;

import com.aaa.mapper.LoginUserMapper;
import com.aaa.mapper.ResourceMapper;
import com.aaa.mapper.RoleMapper;
import com.aaa.pojo.LoginUser;
import com.aaa.pojo.Resource;
import com.aaa.pojo.ResourceVo;
import com.aaa.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements  UserService {
    @Autowired
    LoginUserMapper loginUserMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public LoginUser selectByNamePwd(LoginUser user)
    {

        return loginUserMapper.selectByNamePwd(user);
    }

    @Override
    public List<Role> selectRolesByLoginId(Integer loginId) {
        return roleMapper.selectByLoginId(loginId);
    }

    @Override
    public List<ResourceVo> selectResourcesByLoginId(Integer loginId) {
        //根据登录ID查找所有的角色
        List<Role>  roles = this.selectRolesByLoginId(loginId);
        List<Integer> ids = new ArrayList<>();
        //根据角色查找所有的资源
        List<Resource> res = new ArrayList<>();
        List<ResourceVo> lists = null;
        if(null != roles && roles.size()>0){
            for (Role role : roles) {
                List<Resource> ll = resourceMapper.selectByRoleId(role.getRoleId());
                res.addAll(ll);
                ids.add(role.getRoleId());
            }
        }
        if(res.size()>0){
            lists = new ArrayList<>();
            for (Resource re : res) {
                List<Resource> ff = resourceMapper.selectByFId(re.getId(),ids);
                if(null != ff && ff.size()>0){
                    ResourceVo vo = new ResourceVo(re,ff);
                    lists.add(vo);
                }
            }
        }
       
        
        
        return lists;
    }

    @Override
    public LoginUser selectByName(String username) {
        LoginUser user = loginUserMapper.selectByName(username);

        return user;
    }

    @Override
    public int changePassword(String username, String pwd) {
        return loginUserMapper.updatePwd(username,pwd);
    }
}
