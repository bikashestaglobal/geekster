package com.geekster.hotel.service;

import com.geekster.hotel.dao.UserRepository;
import com.geekster.hotel.dto.UserLoginRequest;
import com.geekster.hotel.dto.UserRequest;
import com.geekster.hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // createUser
    public Map<Object, Object> createUser(UserRequest userRequest){
        Map<Object, Object> resMap = new HashMap();
        User existUser = userRepository.findByEmail(userRequest.getEmail());
        if(existUser == null){
            User user = User.build(null, userRequest.getName()
                    ,userRequest.getEmail(),userRequest.getPassword(),
                    null,null);
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
            user.setPassword(null);
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

}
