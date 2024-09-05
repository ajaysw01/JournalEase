package com.ajaysw.service;

import com.ajaysw.entity.JournalEntry;
import com.ajaysw.repo.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository  journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries(){
        return journalEntryRepository.findAll();
    }


    public Optional<JournalEntry> findByid(ObjectId id){
        return journalEntryRepository.findById(id);
    }


    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }



}
