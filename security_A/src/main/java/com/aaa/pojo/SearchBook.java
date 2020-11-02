package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchBook {
    private Integer bookId;

    private String bookName;

    private Integer publishId;

    private Integer page;

    private Integer limit;
}
