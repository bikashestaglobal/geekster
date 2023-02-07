package com.geekster.userapi.service;

import com.geekster.userapi.model.User.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {
    private static List<User> users= new ArrayList<>();
    private static int id = 1;

    // add some data
    static {
        users.add(new User(id++, "Bikash", "bikashak47", "Purnea", "9117162463"));
    }

    // getAllUsers
    public List<User> getAllUsers(){
        return users;
    }

    // createUser
    public User createUser(User newUser){
        newUser.setUserId(id++);
        users.add(newUser);
        return newUser;
    }

    // getUserById
    public User getUserById(int id){
        Predicate<? super User> predicate = (usr)-> usr.getUserId() ==id;
        User foundUser = users.stream().filter(predicate).findFirst().get();
        return foundUser;
    }
    // deleteUser
    public void deleteUser(int id){
        Predicate<?super User> predicate = user->user.getUserId()==id;
        users.removeIf(predicate);
    }

    // updateUser
    public User updateUser(int id, User newData){
        User user = getUserById(id);
        user.setName(newData.getName());
        user.setUserName(newData.getUserName());
        user.setAddress(newData.getAddress());
        user.setPhoneNumber(newData.getPhoneNumber());
        return user;
    }
}
