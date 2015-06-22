package com.bs.hzexample.application;

import com.bs.hzexample.domain.person.Person;

import java.util.Collection;

public interface PersonAppService {

    void addPerson(Person person);

    Collection<Person> findAll();


}
