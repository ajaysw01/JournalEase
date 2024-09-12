package com.ajaysw.controller;

import com.ajaysw.api.response.WeatherResponse;
import com.ajaysw.entity.User;
import com.ajaysw.repo.UserRepository;
import com.ajaysw.service.UserService;
import com.ajaysw.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUSer(userInDb);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteByUserId(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/greetings")
    public ResponseEntity<?> greetings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");

        String greeting = "Hi " + authentication.getName();

        if (weatherResponse != null && weatherResponse.getCurrent() != null) {
            // Log the entire weather response for debugging
            System.out.println("WeatherResponse: " + weatherResponse);
            System.out.println("Current Weather: " + weatherResponse.getCurrent());

            greeting += ", Weather Feels Like: " + weatherResponse.getCurrent().getFeelslike();
        } else {
            greeting += ", Weather data is unavailable at the moment.";
        }

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }


}
