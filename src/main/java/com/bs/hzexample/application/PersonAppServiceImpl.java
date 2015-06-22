package com.bs.hzexample.application;

import com.bs.hzexample.domain.person.Person;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PersonAppServiceImpl implements PersonAppService {

    @Override
    public void addPerson(Person person) {

    }

    @Override
    public Collection<Person> findAll() {
        return null;
    }
}
