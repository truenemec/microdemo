package com.microdemo.dictionaryservice.service;

import com.microdemo.dictionaryservice.domain.Dictionary;
import com.microdemo.dictionaryservice.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    public Iterable<Dictionary> getAll() {
        return dictionaryRepository.findAll();
    }
}
