package com.geekster.college.service;

import com.geekster.college.dao.LaptopRepository;
import com.geekster.college.dao.StudentRepository;
import com.geekster.college.dto.LaptopRequest;
import com.geekster.college.model.Laptop;
import com.geekster.college.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    StudentRepository studentRepository;

    // createLaptop
    public Laptop createLaptop(LaptopRequest lapReq){
        Student student = studentRepository.findById(lapReq.getStudentId()).get();
        Laptop laptop = Laptop.build(0, lapReq.getName(), lapReq.getBrand(), lapReq.getPrice(), student);
        return laptopRepository.save(laptop);
    }

    // getAllLaptops
    public List<Laptop> getAllLaptops(){
        return laptopRepository.findAll();
    }
}
