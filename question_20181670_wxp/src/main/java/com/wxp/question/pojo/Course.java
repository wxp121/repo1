package com.wxp.question.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Course {
    private Integer course_id;
    private String course_name;
    private Integer num;
    private String inroduce;
}
