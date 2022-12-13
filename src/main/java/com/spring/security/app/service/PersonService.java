package com.spring.security.app.service;

import com.spring.security.app.entity.Person;

import java.util.Optional;

public interface PersonService {

    Optional<Person> findPersonByUsername(String username);

    void register(Person person);
}
