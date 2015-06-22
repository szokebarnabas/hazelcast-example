package com.bs.hzexample.infrastructure.driven.persistence;

import com.bs.hzexample.domain.person.Person;
import com.bs.hzexample.domain.person.PersonId;
import com.bs.hzexample.domain.person.PersonRepository;
import com.google.common.base.Preconditions;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
public class PersonHZRepository implements PersonRepository {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Override
    public Person find(PersonId personId) {
        Preconditions.checkNotNull(personId, "PersonId cannot be null");
        return getPersonIMap().get(personId);
    }

    private IMap<PersonId, Person> getPersonIMap() {
        return hazelcastInstance.getMap("personMap");
    }

    @Override
    public Collection<Person> findAll() {
        return getPersonIMap().values();
    }

    @Override
    public void save(Person person) {
        Preconditions.checkNotNull(person, "Person cannot be null");
        getPersonIMap().put(person.getID(), person);
    }

    @Override
    public void update(Person person) {
        Preconditions.checkNotNull(person, "Person cannot be null");
        getPersonIMap().put(person.getID(), person);
    }

    @Override
    public void remove(PersonId personId) {
        getPersonIMap().remove(personId);
    }

    @Override
    public void removeAll() {
        getPersonIMap().clear();
    }
}
