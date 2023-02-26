package com.geekster.college.controller;

import com.geekster.college.dto.LaptopRequest;
import com.geekster.college.model.Laptop;
import com.geekster.college.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/laptops")
public class LaptopController {
    @Autowired
    LaptopService laptopService;


    // createLaptop
    @PostMapping("")
    public Laptop getAllLaptops(@RequestBody LaptopRequest laptopRequest){
        return laptopService.createLaptop(laptopRequest);
    }

    // getAllLaptops
    @GetMapping("")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }
}
