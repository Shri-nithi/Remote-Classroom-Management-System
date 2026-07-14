package com.example.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.entity.User;
import com.example.java.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email) {
        return userRepository.findByEmail(email);
    }
    public User getUserById(Long id){

    return userRepository.findById(id).orElse(null);

}
public User updateUser(Long id, User user){

    User existingUser = userRepository.findById(id).orElse(null);

    if(existingUser != null){

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());

        return userRepository.save(existingUser);
    }

    return null;
}
}