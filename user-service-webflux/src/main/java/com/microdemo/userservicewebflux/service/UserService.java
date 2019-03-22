package com.microdemo.userservicewebflux.service;

import com.microdemo.userservicewebflux.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Service
public class UserService {

    private Map<Long, User> users  = Stream.of(User.builder().id(1L).firstName("test1").lastName("test1").build(),
        User.builder().id(2L).firstName("test2").lastName("test2").build()).collect(Collectors.toMap(u -> u.getId(), u -> u));


    public Mono<User> get(Long id){
        return  Mono.just(users.get(id));
    }

    public Flux<User> getAll(){
        return Flux.fromStream(LongStream.range(1, 10)
                .mapToObj(i-> User.builder().id(i).firstName("name - " + i).lastName("lastname - " + i).build()))
                .delayElements(Duration.ofSeconds(1));
    }
}
