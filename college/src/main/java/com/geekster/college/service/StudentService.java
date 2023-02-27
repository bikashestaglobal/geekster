package com.geekster.college.service;

import com.geekster.college.dao.StudentRepository;
import com.geekster.college.dto.StudentRequest;
import com.geekster.college.exception.UserNotFoundException;
import com.geekster.college.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        List<Student> students = studentRepository.findAll();
        return students;
    }


    // getStudentById
    public Student getStudentById(int id) throws UserNotFoundException {
        if(studentRepository.findById(id).isPresent()){
            return studentRepository.findById(id).get();
        }else{
            throw new UserNotFoundException("User not found");
        }
    }

    // updateStudent
    public Student updateStudent(StudentRequest studentRequest, int id) {
        Student oldStudent = studentRepository.findById(id).get();
        oldStudent.setName(studentRequest.getName());
        oldStudent.setAge(studentRequest.getAge());
        oldStudent.setPhoneNumber(studentRequest.getPhoneNumber());
        oldStudent.setBranch(studentRequest.getBranch());
        oldStudent.setDepartment(studentRequest.getDepartment());
        oldStudent.setAddress(studentRequest.getAddress());
        return studentRepository.save(oldStudent);
    }

    // deleteStudent
    public Student deleteStudent(int id) throws Exception{
        Student student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return student;
    }
}
