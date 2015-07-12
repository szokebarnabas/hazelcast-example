package com.bs.hzexample.application;

import com.bs.hzexample.domain.person.Person;
import com.bs.hzexample.domain.person.PersonId;
import com.bs.hzexample.domain.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonAppServiceImpl implements PersonAppService {

    private PersonRepository personRepository;

    @Autowired
    public PersonAppServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findPerson(PersonId personId) {
        return personRepository.find(personId);
    }
}
