package com.ajaysw.service;

import com.ajaysw.entity.User;
import com.ajaysw.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetailsServiceImplTests {

    @InjectMocks
    private CustomUserDetailsServiceImpl  customUserDetailsServiceImpl;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setuup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadUserByUserName(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("aja").build());
        UserDetails userDetails = customUserDetailsServiceImpl.loadUserByUsername("ram");
        Assertions.assertNotNull(userDetails);
    }




}
