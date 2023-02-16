package com.example.crud2.controller;

import com.example.crud2.model.Library;
import com.example.crud2.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {
    @Autowired
    LibraryService libraryService;


    // getAllLibrary
    @GetMapping("")
    public List<Library> getAllLibrary(){
        return libraryService.getAllLibrary();
    }

    // getLibraryById
    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable int id){
        return libraryService.getLibraryById();

    }

    // createLibrary
    @PostMapping("")
    public ResponseEntity<String> createLibrary(@RequestBody Library library){
        libraryService.createLibrary(library);
        return new ResponseEntity<String>("Library Added", HttpStatus.CREATED);
    }
}
