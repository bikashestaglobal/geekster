package com.geekster.chatty.service;

import com.geekster.chatty.dao.StatusRepository;
import com.geekster.chatty.dao.UserRepository;
import com.geekster.chatty.dto.UserLoginRequest;
import com.geekster.chatty.dto.UserRequest;
import com.geekster.chatty.model.Status;
import com.geekster.chatty.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatusRepository statusRepository;

    // createUser
    public Map<Object, Object> createUser(UserRequest userRequest){
        Map<Object, Object> resMap = new HashMap();
        User existUser = userRepository.findByEmail(userRequest.getEmail());
        if(existUser == null){
            // get Status
            Status status = statusRepository.findById(1).get();
            User user = User.build(null, userRequest.getName(),
                    userRequest.getMobile(),userRequest.getEmail(),userRequest.getPassword(),
                    status,null,null);
            User savedUser = userRepository.save(user);
            savedUser.setPassword(null);
            resMap.put("body", savedUser);
        }else{
            resMap.put("message", "User already exists");
        }
        return resMap;
    }

    // getUserById
    public Map<Object, Object> getUserById(int id) throws NoSuchElementException {
        User user = userRepository.findById(id).get();
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

    // userLogin
    public Map<Object, Object> userLogin(UserLoginRequest userRequest) {
        Map<Object, Object> resMap = new HashMap();
        User user = userRepository.findByEmail(userRequest.getEmail());
        if(user != null){
            // Check Password
            if(user.getPassword().equals(userRequest.getPassword())){
                resMap.put("body", userRepository.save(user));
            }else{
                resMap.put("message", "Password doesn't Matched");
            }

        }else{
            resMap.put("message", "User doesn't Exist");
        }
        return resMap;
    }

    // deleteUser
    public Map<Object, Object> deleteUser(int id) {
        Map<Object, Object> resMap = new HashMap();
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            Status status = statusRepository.findById(2).get();
            user.setStatus(status);
            User updatedUser = userRepository.save(user);
            updatedUser.setPassword(null);
            resMap.put("body", updatedUser);
        }else{
            resMap.put("message", "User doesn't Exist");
        }
        return resMap;
    }
}
