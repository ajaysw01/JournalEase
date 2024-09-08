package com.ajaysw.controller;

import com.ajaysw.entity.User;
import com.ajaysw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @GetMapping("health")
    public String healthCheck(){
        return "Health Check";
    }


    @PostMapping("create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUSer(user);
    }
}
