package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVo {
    private Integer id;

    private String menuName;

    private String menuUrl;

    private Integer parentId;

    private Integer type;

    private String remark;

    private Integer state;

    private List<Resource> sonList;

    public ResourceVo(Resource r,List<Resource> son){
        this.id = r.getId();
        this.menuName = r.getMenuName();
        this.menuUrl = r.getMenuUrl();
        this.parentId = r.getParentId();
        this.type = r.getType();
        this.remark = r.getRemark();
        this.state = r.getState();
        this.sonList = son;
    }
}
