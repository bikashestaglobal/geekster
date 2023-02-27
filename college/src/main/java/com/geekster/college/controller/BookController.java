package com.geekster.college.controller;

import com.geekster.college.dto.BookRequest;
import com.geekster.college.exception.DataNotFoundException;
import com.geekster.college.model.Book;
import com.geekster.college.service.BookService;
import jakarta.validation.Valid;
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

    // getBookById
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) throws DataNotFoundException {
        return bookService.getBookById(id);
    }

    // updateBook
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @Valid @RequestBody BookRequest bookRequest) throws DataNotFoundException {
        return bookService.updateBook(id, bookRequest);
    }
}
