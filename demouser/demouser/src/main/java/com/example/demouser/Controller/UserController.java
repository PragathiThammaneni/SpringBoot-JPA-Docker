package com.example.demouser.Controller;

import com.example.demouser.Service.UserService;
import com.example.demouser.Model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

    @RestController
    @RequestMapping("/api")
    public class UserController {


        @Autowired
        private UserService userService;

        public UserController(){

        }

        @GetMapping("/user")
        public User getUser(){

            return userService.getUser("Pragathi");
        }

        @GetMapping("/users")
        public List<User> getUsers(){
            return userService.getUsers();
        }

        @PostMapping(path = "/user/add")
        public void addUser(Long id, @RequestBody User user) {
            userService.addUser(user);
        }

        @PutMapping(path = "/user/update/{userId}")
        public void updateUser(@PathVariable long userId, @RequestBody User user) {
            userService.updateUser(userId,user);
        }

        @DeleteMapping(path = "/user/delete/{userId}")
        public void deleteUser(@PathVariable long userId) {
            userService.deleteUser(userId);
        }

        @GetMapping(path ="/user/count")
        public long countUsers(){
            return userService.countUser();
        }
    }
