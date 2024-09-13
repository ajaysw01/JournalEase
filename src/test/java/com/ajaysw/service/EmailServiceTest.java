package com.ajaysw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    public void testsendMail(){
        emailService.sendEmail("ajaysw44@gmail.com","Tsting mail sender","Hleo");
    }
}
