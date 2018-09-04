package com.microdemo.userservice.controller;

import com.microdemo.userservice.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    @HystrixCommand(fallbackMethod = "getDefault")
    public User get(){
        User user = new User();
        user.setId(1L);
        return user;
    }

    public User getDefault() {
        return null;
    }
}
