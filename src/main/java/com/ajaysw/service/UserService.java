package com.ajaysw.service;

import com.ajaysw.entity.User;
import com.ajaysw.repo.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    public void saveNewUSer(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName) {
        return  userRepository.findByUserName(userName);
    }
}
