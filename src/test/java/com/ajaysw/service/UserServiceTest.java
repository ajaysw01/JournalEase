package com.ajaysw.service;

import com.ajaysw.entity.User;
import com.ajaysw.repo.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @BeforeEach
//    @BeforeAll
//    @AfterEach
//    @AfterAll


    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "ajay",
            "harsh"
    })
    public void testFindByUserName(String name) {
        assertNotNull(userRepository.findByUserName(name),"faild to find user by name"+name);
    }

    @Disabled
    @CsvSource({
            "1,1,2",
            "2,2,4",
            "1,2,32"
    }
    )
    @ParameterizedTest
    public void addtest(int a, int b, int expected){
        assertEquals(expected, a+b);
    }


//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public  void testSavenewuser(User user){
//            assertEquals(userService.saveNewUSer(user));
//    }
}
