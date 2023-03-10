package com.geekster.college.service;

import com.geekster.college.dao.BookRepository;
import com.geekster.college.dao.StudentRepository;
import com.geekster.college.dto.BookRequest;
import com.geekster.college.exception.DataNotFoundException;
import com.geekster.college.model.Book;
import com.geekster.college.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    StudentRepository studentRepository;


    // createBook
    public Book createBook(BookRequest bookReq) {
        Student student = studentRepository.findById(bookReq.getStudentId()).get();
        Book book = Book.build(0, bookReq.getTitle(), bookReq.getAuthor(),bookReq.getDescription(),bookReq.getPrice(), student);
        return bookRepository.save(book);
    }

    // getAllBooks
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // getBookById
    public Book getBookById(int id) throws DataNotFoundException {
        if(bookRepository.findById(id).isPresent()){
            Book book = bookRepository.findById(id).get();
            return bookRepository.save(book);
        }else{
            throw new DataNotFoundException("Book not Found");
        }
    }

    // updateBook
    public Book updateBook(int id, BookRequest bookRequest) throws DataNotFoundException {
        if(bookRepository.findById(id).isPresent()){
            Book oldBook = bookRepository.findById(id).get();
            oldBook.setTitle(bookRequest.getTitle());
            oldBook.setAuthor(bookRequest.getAuthor());
            oldBook.setDescription(bookRequest.getDescription());
            oldBook.setPrice(bookRequest.getPrice());
            return bookRepository.save(oldBook);
        }else{
            throw new DataNotFoundException("Book not Found");
        }
    }
}
