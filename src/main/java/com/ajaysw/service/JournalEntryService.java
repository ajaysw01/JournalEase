package com.ajaysw.service;

import com.ajaysw.entity.JournalEntry;
import com.ajaysw.entity.User;
import com.ajaysw.repo.JournalEntryRepository;
import com.ajaysw.repo.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository  journalEntryRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw  new RuntimeException("An error occurred while saving journal entry");
        }
    }
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }


    public List<JournalEntry> getAllEntries(){
        return journalEntryRepository.findAll();
    }


    public Optional<JournalEntry> findByid(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){

        boolean removed = false;
        try {

           User user = userService.findByUserName(userName);
           removed =  user.getJournalEntries().removeIf(x -> x.getId().equals(id));
           if(removed){
               userService.saveUser(user);
               journalEntryRepository.deleteById(id);
           }


       }catch (Exception e){
           System.out.println(e.getMessage());
           throw  new RuntimeException("An error occurred while deleting journal entry");
       }
        return  removed;
    }

    public List<JournalEntry> findByUserName(String userName){
        return  null;
    }

}
