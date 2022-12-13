package com.spring.security.app.service.impl;

import com.spring.security.app.entity.Person;
import com.spring.security.app.repository.PersonRepository;
import com.spring.security.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<Person> findPersonByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void register(Person person) {
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        person.setRole("ROLE_USER ");
        personRepository.save(person);
    }
}
