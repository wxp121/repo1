package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRole {
    private Integer resourceRoleId;

    private Integer roleId;

    private Integer resourcesId;

    private Integer state;

}