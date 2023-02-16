package com.example.eventmanagement.controller;

import com.example.eventmanagement.model.Student;
import com.example.eventmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    // createStudent
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.createStudent(student), HttpStatus.CREATED);
    }


    // getAllStudents
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // getStudentById
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    // updateStudent
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
        return new ResponseEntity<Student>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    // deleteStudent
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);
    }

}
