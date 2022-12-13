package com.spring.security.app.util;

import com.spring.security.app.entity.Person;
import com.spring.security.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    @Autowired
    private PersonService personService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personService.findPersonByUsername(person.getUsername()).isPresent()){
            errors.rejectValue("username", "User with entered username exist");
        }


    }
}
