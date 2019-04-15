package com.microdemo.userservice.controller;

import com.microdemo.userservice.domain.User;
import com.microdemo.userservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @HystrixCommand(fallbackMethod = "getDefault")
    public User get( @PathVariable("id")Long id){
        return userService.get(id);
    }
    @GetMapping
    @HystrixCommand(fallbackMethod = "getDefaultAll")
    public Iterable<User> getAll(){
        log.debug("getAll");
        return userService.getAll();
    }

    public User getDefault(Long id) {
        return null;
    }
    public Iterable<User> getDefaultAll() {
        return Collections.emptyList();
    }

}
