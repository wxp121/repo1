package com.wxp.pojo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TeacherVo {

    private Integer teacher_id;
    private String teacher_name;
    private String teacher_sex;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date teacher_birth;
    private String teacher_photo;
    private Classes classes;

}
