package com.geekster.valiation.controller;

import com.geekster.valiation.model.User;
import com.geekster.valiation.service.UserService;
import com.geekster.valiation.dto.UserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    // getAllUsers
    @GetMapping("/getAllUser")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // getUserById
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    // addUser
    @PostMapping("/addUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest reqBody){

        int userId = userService.createUser(reqBody);
        return new ResponseEntity<>("User created with id: "+userId, HttpStatus.CREATED);
    }

    // updateUser
    @PutMapping("/updateUserInfo/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User reqBody, @PathVariable int id){
        userService.updateUser(id, reqBody);
        return new ResponseEntity<>("User updated ! ", HttpStatus.OK);
    }

    // deleteUser
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted !",HttpStatus.OK);
    }

}
