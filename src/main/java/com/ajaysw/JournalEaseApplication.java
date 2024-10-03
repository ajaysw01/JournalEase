package com.ajaysw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class JournalEaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(JournalEaseApplication.class, args);
    }

    @Bean
    public PlatformTransactionManager falana(MongoDatabaseFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
