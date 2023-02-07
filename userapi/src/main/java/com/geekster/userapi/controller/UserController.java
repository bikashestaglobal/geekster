package com.geekster.userapi.controller;

import com.geekster.userapi.model.User.User;
import com.geekster.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private final UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

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


    // createUser
    @PostMapping("/addUser")
    public User getUserById(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    // updateUser
    @PutMapping("/updateUserInfo/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable int id){
        return userService.updateUser(id, newUser);
    }

    // deleteUser
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
    }
}
