package com.karuturirs.gcp.webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequestMapping("/api/book")
public class BookController {


    @GetMapping("/{id}")
    public String findById(@PathVariable long id) {
        return "Book::" + id;
    }

}