package com.bs.hzexample.domain.person;

import java.util.Collection;

public interface PersonRepository {

    Person find(PersonId personId);

    Collection<Person> findAll();

    void save(Person person);

    void update(Person person);

    void remove(PersonId personId);

    void removeAll();
}
