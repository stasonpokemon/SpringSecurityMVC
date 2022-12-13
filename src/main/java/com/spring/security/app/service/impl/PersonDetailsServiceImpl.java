package com.spring.security.app.service.impl;

import com.spring.security.app.entity.Person;
import com.spring.security.app.repository.PersonRepository;
import com.spring.security.app.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);

        if (!person.isPresent()){
            throw new UsernameNotFoundException(new StringBuilder("User with name = ")
                    .append(username)
                    .append(" not found").toString());
        }
        return new PersonDetails(person.get());

    }
}
