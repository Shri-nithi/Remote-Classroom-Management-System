package com.example.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.entity.User;
import com.example.java.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/login/{email}")
    public User loginUser(@PathVariable String email) {
        return userService.loginUser(email);
    }

    @GetMapping("/{id}")
public User getUserById(@PathVariable Long id){

    return userService.getUserById(id);

}
@PutMapping("/{id}")
public User updateUser(
        @PathVariable Long id,
        @RequestBody User user){

    return userService.updateUser(id, user);

}
    
}