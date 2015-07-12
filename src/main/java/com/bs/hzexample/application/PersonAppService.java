package com.bs.hzexample.application;

import com.bs.hzexample.domain.person.Person;
import com.bs.hzexample.domain.person.PersonId;

public interface PersonAppService {

    void addPerson(Person person);

    Person findPerson(PersonId personId);
}
