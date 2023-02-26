package com.geekster.college.controller;

import com.geekster.college.dto.BookRequest;
import com.geekster.college.model.Book;
import com.geekster.college.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    BookService bookService;

    // createBook
    @PostMapping("")
    public Book createBook(@RequestBody BookRequest bookRequest){
        return bookService.createBook(bookRequest);
    }

    // getAllBooks
    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

}
