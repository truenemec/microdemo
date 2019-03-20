package com.microdemo.userservice.repository;

import com.microdemo.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
