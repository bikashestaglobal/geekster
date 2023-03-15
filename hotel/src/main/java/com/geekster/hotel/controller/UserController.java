package com.geekster.hotel.controller;

import com.geekster.hotel.dto.UserLoginRequest;
import com.geekster.hotel.dto.UserRequest;
import com.geekster.hotel.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.CREATED);
            resObj.put("message", "User Added Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.CREATED);
        }
    }

    // userLogin
    @PostMapping("/login")
    public ResponseEntity<Object> userLogin(@Valid @RequestBody UserLoginRequest userRequest){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> errorObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.userLogin(userRequest);
        if(serviceResponse.containsKey("message")){
            errorObj.put("error", serviceResponse.get("message"));
            resObj.put("status", HttpStatus.BAD_REQUEST);
            resObj.put("message", "Oops Error occurred !");
            resObj.put("error", errorObj);
            return new ResponseEntity<>(resObj, HttpStatus.BAD_REQUEST);
        }else{
            resObj.put("body", serviceResponse.get("body"));
            resObj.put("status", HttpStatus.CREATED);
            resObj.put("message", "User Logged in Successfully !");
            return new ResponseEntity<>(resObj, HttpStatus.CREATED);
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllUsers(){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getAllUsers();

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(required = true) int id){
        Map<Object, Object> resObj = new HashMap<>();
        Map<Object, Object> serviceResponse = userService.getUserById(id);

        resObj.put("body", serviceResponse.get("body"));
        resObj.put("status", HttpStatus.OK);
        resObj.put("message", "User Fetched Successfully !");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }
}
