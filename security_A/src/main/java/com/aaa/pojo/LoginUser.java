package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {
    private Integer userId;

    private String loginName;

    private String loginPwd;

    private String userRealName;

    private Integer userState;
}
