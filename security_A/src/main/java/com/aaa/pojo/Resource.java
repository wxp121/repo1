package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    private Integer id;

    private String menuName;

    private String menuUrl;

    private Integer parentId;

    private Integer type;

    private String remark;

    private Integer state;
}
