package com.geekster.college.service;

import com.geekster.college.dao.StudentRepository;
import com.geekster.college.dto.StudentRequest;
import com.geekster.college.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // createStudent
    public Student createStudent(StudentRequest studentRequest){
        Student student = Student.build(0, studentRequest.getName(),studentRequest.getAge(),studentRequest.getPhoneNumber(),studentRequest.getBranch(),studentRequest.getDepartment(),null,studentRequest.getAddress());
        return studentRepository.save(student);
    }

    // getAllStudents
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


}
