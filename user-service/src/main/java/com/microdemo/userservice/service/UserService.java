package com.microdemo.userservice.service;

import com.microdemo.userservice.domain.User;
import com.microdemo.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User get(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> getAll(){
        return userRepository.findAll();
    }
}
