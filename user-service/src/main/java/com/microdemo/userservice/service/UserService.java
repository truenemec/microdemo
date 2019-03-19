package com.microdemo.userservice.service;

import com.microdemo.userservice.domain.User;
import com.microdemo.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User get(Long id){
        return userRepository.get(id);
    }
    public Collection<User> getAll(){
        return userRepository.getAll();
    }
}
