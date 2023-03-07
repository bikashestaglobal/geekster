package com.geekster.doctorapp.controller;

import com.geekster.doctorapp.dto.DoctorRequest;
import com.geekster.doctorapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    // createDoctor
    @PostMapping("")
    public ResponseEntity<Object> createDoctor(@Valid @RequestBody DoctorRequest doctorRequest){
        Map<Object, Object> serviceRes = doctorService.createDoctor(doctorRequest);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Doctor Created Successfully");
        resMap.put("status" , HttpStatus.CREATED);
        return new ResponseEntity<>(resMap, HttpStatus.CREATED);
    }

    // getAllDoctors
    @GetMapping("")
    public ResponseEntity<Object> getAllDoctors(){
        Map<Object, Object> serviceRes = doctorService.getAllDoctors();
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Doctor Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }
    // getDoctorById
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctorById(@PathVariable(required = true) int id) throws Exception {
        Map<Object, Object> serviceRes = doctorService.getDoctorById(id);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Doctor Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }


    // updateDoctor
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDoctor(@PathVariable(required = true) int id, @RequestBody DoctorRequest doctorRequest) throws Exception {
        Map<Object, Object> serviceRes = doctorService.updateDoctor(id, doctorRequest);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Doctor Updated Successfully");
        resMap.put("status" , HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }
}
