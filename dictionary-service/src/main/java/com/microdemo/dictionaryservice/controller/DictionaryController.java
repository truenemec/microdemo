package com.microdemo.dictionaryservice.controller;

import com.microdemo.dictionaryservice.domain.Dictionary;
import com.microdemo.dictionaryservice.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping
    public Iterable<Dictionary> getAll(){
        return dictionaryService.getAll();
    }
}
