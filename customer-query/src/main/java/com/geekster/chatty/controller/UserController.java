package com.geekster.chatty.controller;

import com.geekster.chatty.dto.UserRequest;
import com.geekster.chatty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    // createUser
    @PostMapping("")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserRequest userRequest){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.createUser(userRequest);
        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.CREATED);
        resObj.put("message", "User Added Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.CREATED);
    }

    // getAllUsers
    @GetMapping("")
    public ResponseEntity<Object> getAllUsers(){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getAllUsers();

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }

    // getUserById
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(required = true) int id){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getUserById(id);

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }

    // getUserByFirstName
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<Object> getUserByFirstName(@PathVariable(required = true) String firstName){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getUserByFirstName(firstName);

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }

    // getUserByLastName
    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<Object> getUserByLastName(@PathVariable(required = true) String lastName){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getUserByLastName(lastName);

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }



    // getUserByAge
    @GetMapping("/age/{age}")
    public ResponseEntity<Object> getUserByAge(@PathVariable(required = true) int age){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getUserByAge(age);

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }


    // getUserByActive
    @GetMapping("/active/{active}")
    public ResponseEntity<Object> getUserByActive(@PathVariable(required = true) Boolean active){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getUserByActive(active);

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }


    // getUserByAdmissionDate
    @GetMapping("/admissionDate/{admissionDate}")
    public ResponseEntity<Object> getUserByAdmissionDate(@PathVariable(required = true) Date admissionDate){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getUserByAdmissionDate(admissionDate);

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }


}
