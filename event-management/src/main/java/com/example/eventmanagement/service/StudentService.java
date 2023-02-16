package com.example.eventmanagement.service;

import com.example.eventmanagement.dao.StudentRepository;
import com.example.eventmanagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // getAllStudents
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // createStudent
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    // getStudentById
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    // updateStudent
    public Student updateStudent(int id, Student student) {
        Student oldStudent = studentRepository.findById(id).get();
        oldStudent.setAge(student.getAge());
        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());
        oldStudent.setDepartment(student.getDepartment());
        return studentRepository.save(oldStudent);
    }

    // deleteStudent
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
