package com.ajaysw.repository;

import com.ajaysw.repo.UserRepository;
import com.ajaysw.repo.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTests {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    public void  testUser(){
        Assertions.assertNotNull(userRepository.getUserForSA());

    }

}
