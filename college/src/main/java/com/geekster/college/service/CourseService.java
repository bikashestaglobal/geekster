package com.geekster.college.service;

import com.geekster.college.dao.CourseRepository;
import com.geekster.college.dao.StudentRepository;
import com.geekster.college.dto.CourseRequest;
import com.geekster.college.dto.CourseStudentRequest;
import com.geekster.college.model.Course;
import com.geekster.college.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    // createCourse
    public Course createCourse(CourseRequest courseRequ) {
        Course course = Course.build(0, courseRequ.getTitle(),courseRequ.getDescription(),courseRequ.getDuration(),null);
        return courseRepository.save(course);
    }

    // getAllCourses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // assignStudentToCourse
    public Course assignStudentToCourse(CourseStudentRequest courseStudentReq) {
        Course course = courseRepository.findById(courseStudentReq.getCourseId()).get();
        Student student = studentRepository.findById(courseStudentReq.getStudentId()).get();
        List<Student> studentList = course.getStudentList();
        studentList.add(student);
        course.setStudentList(studentList);
        courseRepository.save(course);
        return course;
    }

}
