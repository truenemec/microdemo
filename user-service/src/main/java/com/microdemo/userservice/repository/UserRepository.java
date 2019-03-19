package com.microdemo.userservice.repository;

import com.microdemo.userservice.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {
    Map<Long, User> users = Stream.of(User.builder().id(1L).firstName("Jone").lastName("Smith").build(),
                              User.builder().id(2L).firstName("Andreas").lastName("Black").build())
            .collect(Collectors.toMap(User::getId, u -> u));
    public User get(Long id){
        return users.get(id);
    }
    public Collection<User> getAll(){
        return users.values();
    }
}
