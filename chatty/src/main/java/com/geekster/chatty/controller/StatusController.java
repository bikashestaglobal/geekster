package com.geekster.chatty.controller;

import com.geekster.chatty.dto.StatusRequest;
import com.geekster.chatty.model.Status;
import com.geekster.chatty.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    // createStatus
    @PostMapping("")
    public ResponseEntity<Object> createStatus(@Valid @RequestBody StatusRequest statusRequest){
        Status serviceResponse = statusService.createStatus(statusRequest);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", serviceResponse);
        resMap.put("message", "Status created successfully");
        resMap.put("status", HttpStatus.CREATED);
        return new ResponseEntity<>(resMap, HttpStatus.CREATED);
    }

    // getStatusById
    @GetMapping("/{id}")
    public ResponseEntity<Object> getStatusById(@PathVariable(required = true, name = "id") int id){
        Status serviceResponse = statusService.getStatusById(id);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", serviceResponse);
        resMap.put("message", "Status fetched successfully");
        resMap.put("status", HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

    // getAllStatus
    @GetMapping("")
    public ResponseEntity<Object> getAllStatus(){
        List<Status> serviceResponse = statusService.getAllStatus();
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", serviceResponse);
        resMap.put("message", "Status fetched successfully");
        resMap.put("status", HttpStatus.OK);
        return new ResponseEntity<>(resMap, HttpStatus.OK);
    }

}
