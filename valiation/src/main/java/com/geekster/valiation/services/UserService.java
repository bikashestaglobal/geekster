package com.geekster.valiation.services;

import com.geekster.valiation.daos.UserRepository;
import com.geekster.valiation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // getAllUsers
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // createUser
    public int createUser(User reqBody) {
        User response = userRepository.save(reqBody);
        return  response.getUserId();
    }

    // getUserById
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    // updateUser
    public void updateUser(int id, User reqBody) {
        User user = userRepository.findById(id).get();
        user.setUserName(reqBody.getUserName());
        user.setDate(reqBody.getDate());
        user.setNumber(reqBody.getNumber());
        user.setTime(reqBody.getTime());
        user.setEmail(reqBody.getEmail());
        userRepository.save(user);
    }

    // deleteUser
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
