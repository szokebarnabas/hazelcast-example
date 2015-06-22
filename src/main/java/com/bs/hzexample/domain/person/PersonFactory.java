package com.bs.hzexample.domain.person;

import com.bs.hzexample.util.ddd.model.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonFactory {

//    @Autowired
    private IDGenerator<String> idGenerator;

    private Person newPerson(PersonName personName, Salutation salutation, BirthDate birthDate, Address address, PhoneNumber phoneNumber, Email email) {
        PersonId personId = PersonId.createFrom(idGenerator.generate());
        return new Person(personId, salutation, personName, birthDate, address, phoneNumber, email);
    }
}
