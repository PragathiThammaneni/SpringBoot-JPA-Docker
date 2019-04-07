package com.example.demouser.Service;

import com.example.demouser.Model.User;
import java.util.*;
import com.example.demouser.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(String str){
        return userRepository.findByLastName(str);
    }

    public void addUser(User user ){
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void updateUser(long userId,User user){
        User userToUpdate = userRepository.getOne(userId);
        userToUpdate.setId(user.getId());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userRepository.save(userToUpdate);
    }

    public void deleteUser(long userId){
        userRepository.deleteById(userId);
    }

    public long countUser(){
        return userRepository.count();
    }

}
