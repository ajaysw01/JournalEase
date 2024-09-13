package com.ajaysw.scheduler;

import com.ajaysw.cache.AppCache;
import com.ajaysw.entity.JournalEntry;
import com.ajaysw.entity.User;
import com.ajaysw.repo.UserRepositoryImpl;
import com.ajaysw.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private AppCache appCache;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

//    @Scheduled(cron = "0 0 9 * * SUN")
    @Scheduled(cron = "0 * * ? * *")
    public void fetchUserAndSendSAMail(){
        List<User>  users = userRepository.getUserForSA();
        for(User user : users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<JournalEntry> filterdEntries = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getContent()).collect(Collectors.toList();
            String entry = String.join(" ", filterdEntries  );
            String sentiment = sentimentAnalysisService.getSentiment(entry);
            emailService.sendEmail(user.getEmail(),"sentiment for last 7 days", sentiment);

        }

    }

    @Scheduled(cron = "0 * * ? * *")
    public void clearAppCache(){
        appCache.init();
    }

}
