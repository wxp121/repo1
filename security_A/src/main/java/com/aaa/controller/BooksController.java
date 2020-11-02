package com.aaa.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booksinfo")

public class BooksController {

    @RequestMapping("/list")
    @PreAuthorize("hasAnyRole('admin','yyh')")
    public String toList(){
        return "books/list";
    }
    @RequestMapping("/add")
    @PreAuthorize("hasAnyRole('admin','yyh')")
    public String toAdd(){
        return "books/add";
    }

    @RequestMapping("/update")
    @PreAuthorize("hasAnyRole('admin')")
    public String toUpdate(){
        return "books/update";
    }
    @PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/delete")
    public String toDelete(){
        return "books/delete";
    }

}