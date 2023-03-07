package com.geekster.doctorapp.controller;

import com.geekster.doctorapp.dto.PatientRequest;
import com.geekster.doctorapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    // createPatient
    @PostMapping("")
    public ResponseEntity<Object> createPatient(@Valid @RequestBody PatientRequest patientRequest){
        Map<Object, Object> serviceRes = patientService.createPatient(patientRequest);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Patient Created Successfully");
        resMap.put("status" , HttpStatus.CREATED);
        return new ResponseEntity<>(resMap, HttpStatus.CREATED);
    }

    // getAllPatients
    @GetMapping("")
    public ResponseEntity<Object> getAllPatients(){
        Map<Object, Object> serviceRes = patientService.getAllPatient();
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Patient Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    // getPatientById
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable int id) throws Exception {
        Map<Object, Object> serviceRes = patientService.getPatientById(id);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Patient Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    // updatePatient
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePatient(@PathVariable int id, @Valid @RequestBody PatientRequest patientRequest) throws Exception {
        Map<Object, Object> serviceRes = patientService.updatePatient(id, patientRequest);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Patient Updated Successfully");
        resMap.put("status" , HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    // deletePatient
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable int id) throws Exception {
        Map<Object, Object> serviceRes = patientService.deletePatient(id);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "Patient Deleted Successfully");
        resMap.put("status" , HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

}
