package com.geekster.valiation.service;

import com.geekster.valiation.dao.UserRepository;
import com.geekster.valiation.model.User;
import com.geekster.valiation.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    public int createUser(UserRequest reqBody) {
        User newUser = User.build(0,reqBody.getUserName(),
                reqBody.getEmail(), reqBody.getDateOfBirth(),
                reqBody.getNumber(),
                reqBody.getDate(), reqBody.getTime(),null,null);

        User response = userRepository.save(newUser);
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
