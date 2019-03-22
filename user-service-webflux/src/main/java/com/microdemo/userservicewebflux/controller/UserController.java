package com.microdemo.userservicewebflux.controller;

import com.microdemo.userservicewebflux.domain.User;
import com.microdemo.userservicewebflux.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @HystrixCommand(fallbackMethod = "getDefault")
    public Mono<User> get(@PathVariable("id")Long id){
        return userService.get(id)
                .subscribeOn(Schedulers.elastic())
                .take(Duration.ofSeconds(5));
    }
    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @HystrixCommand(fallbackMethod = "getDefaultAll")
    public Flux<User> getAll(){
        return userService.getAll()
                .subscribeOn(Schedulers.elastic())
                //.take(Duration.ofSeconds(5))
                ;
    }

    public Mono<User> getDefault(Long id) {
        return Mono.empty();
    }
    public Flux<User> getDefaultAll() {
        return Flux.empty();
    }

}
