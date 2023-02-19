package com.geekster.onlineshopping.service;

import com.geekster.onlineshopping.dao.UserRepository;
import com.geekster.onlineshopping.model.User;
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

    // getUserById
    public User getUserById(int id){
        return userRepository.findById(id).get();
    }

    // createUser
    public User createUser(User user){
        return userRepository.save(user);
    }

    // updateUser
    public User updateUser(int id, User reqUser){
        User user = getUserById(id);
        user.setName(reqUser.getName());
        user.setEmail(reqUser.getEmail());
        user.setPhoneNumber(reqUser.getPhoneNumber());
        user.setPassword(reqUser.getPassword());
        return userRepository.save(user);
    }

    // deleteUser
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


}
