package com.aaa.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Publish {
    private Integer pubId;

    private String pubName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;

}