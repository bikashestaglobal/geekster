package com.geekster.college.controller;

import com.geekster.college.dto.StudentRequest;
import com.geekster.college.exception.UserNotFoundException;
import com.geekster.college.model.Student;
import com.geekster.college.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;


    // createUser
    @PostMapping("")
    public Student createStudent(@Valid @RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    // getAllStudents
    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // getStudentById
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) throws UserNotFoundException {
        return studentService.getStudentById(id);
    }


    // updateStudent
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentRequest, id);
    }

    // deleteStudent
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) throws Exception {
        return studentService.deleteStudent(id);
    }

}
