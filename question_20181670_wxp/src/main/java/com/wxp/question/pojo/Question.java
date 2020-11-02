package com.wxp.question.pojo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Question {
        private Integer id;
        private String query;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date creat_date;
        private String level;
        private Integer coures_id;
}
