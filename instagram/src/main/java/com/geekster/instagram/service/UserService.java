package com.geekster.instagram.service;

import com.geekster.instagram.dao.UserRepository;
import com.geekster.instagram.dto.RequestUser;
import com.geekster.instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // createUser
    public Map<Object, Object> createUser(RequestUser requestUser){
        User existingUser = userRepository.findByEmail((requestUser.getEmail()));
        Map<Object, Object> resMap = new HashMap<>();
        if(existingUser != null){
            resMap.put("error", "User already exists");
        }else{
            User user = new User(0,requestUser.getName(), requestUser.getEmail(), requestUser.getPassword(), true, null, null);
            User savedUser = userRepository.save(user);
            resMap.put("body", savedUser);
        }

        return resMap;
    }

    // getUserById
    public Map<Object,Object> getUserById(int id) throws Exception{
        Map<Object, Object> resMap = new HashMap<>();
        User user = userRepository.findById(id).get();
        resMap.put("body", user);
        return resMap;
    }

    // getAllUsers
    public Map<Object,Object> getAllUsers(){
        Map<Object, Object> resMap = new HashMap<>();
        List<User> users = userRepository.findAll();
        resMap.put("body", users);
        return resMap;
    }



}
