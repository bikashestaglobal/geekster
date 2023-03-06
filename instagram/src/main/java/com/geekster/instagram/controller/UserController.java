package com.geekster.instagram.controller;

import com.geekster.instagram.dto.RequestUser;
import com.geekster.instagram.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Map<Object,Object> createUser(@Valid @RequestBody RequestUser requestUser){
        Map<Object, Object> serviceRes = userService.createUser(requestUser);
        Map<Object, Object> resMap = new HashMap<>();
        if(serviceRes.containsKey("error")){
            resMap.put("error" , serviceRes.get("error"));
            resMap.put("message" , "Validation Failed");
            resMap.put("status" , HttpStatus.BAD_REQUEST);
        }else{
            resMap.put("body" , serviceRes.get("body"));
            resMap.put("message" , "User Added Successfully");
            resMap.put("status" , HttpStatus.OK);
        }
        return resMap;
    }

    // getAllUsers
    @GetMapping("")
    public Map<Object, Object> getAllUsers() {
        Map<Object,Object> serviceRes =  userService.getAllUsers();
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "User Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return resMap;
    }

    // getUserById
    @GetMapping("/{id}")
    public Map<Object, Object> getUserById(@PathVariable int id) throws Exception {
        Map<Object,Object> serviceRes =  userService.getUserById(id);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body" , serviceRes.get("body"));
        resMap.put("message" , "User Fetched Successfully");
        resMap.put("status" , HttpStatus.OK);
        return resMap;
    }


}
