package com.geekster.college.controller;

import com.geekster.college.dto.StudentRequest;
import com.geekster.college.model.Student;
import com.geekster.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;


    // createUser
    @PostMapping("")
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    // getAllStudents
    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
