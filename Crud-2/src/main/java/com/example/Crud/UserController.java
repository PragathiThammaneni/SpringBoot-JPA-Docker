package com.example.Crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PutMapping("/users/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User userObject)
    {
        User user = userRepository.findById(id).get();
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }



   @DeleteMapping("/users/{id}")
    public List<User> delete(@PathVariable("id") Long id)
    {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }

}
