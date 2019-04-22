package com.microdemo.dictionaryservice.repository;

import com.microdemo.dictionaryservice.domain.Dictionary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends CrudRepository<Dictionary, Long> {
}
