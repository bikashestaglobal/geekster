package com.geekster.college.controller;

import com.geekster.college.dto.CourseRequest;
import com.geekster.college.dto.CourseStudentRequest;
import com.geekster.college.model.Course;
import com.geekster.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    // createCourse
    @PostMapping("")
    public Course createCourse(@RequestBody CourseRequest courseRequest){
        return courseService.createCourse(courseRequest);
    }

    // getAllCourses
    @GetMapping("")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    // assignStudentToCourse
    @PostMapping("/assignStudent")
    public Course createCourse(@RequestBody CourseStudentRequest courseStudentRequest){
        return courseService.assignStudentToCourse(courseStudentRequest);
    }
}
