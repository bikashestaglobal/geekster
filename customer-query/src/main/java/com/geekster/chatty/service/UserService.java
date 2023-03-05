package com.geekster.chatty.service;

import com.geekster.chatty.dao.UserRepository;
import com.geekster.chatty.dto.UserRequest;
import com.geekster.chatty.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // createUser
    public Map<Object, Object> createUser(UserRequest userRequest){
        Map<Object, Object> resMap = new HashMap();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = User.build(null, userRequest.getFirstName(),userRequest.getLastName(), userRequest.getAge(), timestamp,true, null, null);
        User savedUser = userRepository.save(user);
        resMap.put("body", savedUser);
        return resMap;
    }

    // getUserById
    public Map<Object, Object> getUserById(int id) throws NoSuchElementException {
        User user = userRepository.findById(id).get();
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", user);
        return resMap;
    }

    // getUserByFirstName
    public Map<Object, Object> getUserByFirstName(String firstName) throws NoSuchElementException {
        List<User> user = userRepository.getUserByFirstName(firstName);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", user);
        return resMap;
    }

    // getUserByLastName
    public Map<Object, Object> getUserByLastName(String lastName) throws NoSuchElementException {
        List<User> user = userRepository.getUserByLastName(lastName);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", user);
        return resMap;
    }



    // getUserByAge
    public Map<Object, Object> getUserByAge(int age) throws NoSuchElementException {
        List<User> user = userRepository.getUserByAge(age);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", user);
        return resMap;
    }

    // getUserByActive
    public Map<Object, Object> getUserByActive(Boolean active) throws NoSuchElementException {
        List<User> user = userRepository.getUserByActive(active);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", user);
        return resMap;
    }

    // getUserByAdmissionDate
    public Map<Object, Object> getUserByAdmissionDate(Date admissionDate) throws NoSuchElementException {
        List<User> user = userRepository.getUserByAdmissionDate((java.sql.Date) admissionDate);
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", user);
        return resMap;
    }

    // getAllUsers
    public Map<Object, Object> getAllUsers() {
        List<User> users = userRepository.findAll();
        Map<Object, Object> resMap = new HashMap<>();
        resMap.put("body", users);
        return resMap;
    }

}
