package com.bs.hzexample.infrastructure.driven;

import com.bs.hzexample.domain.person.Address;
import com.bs.hzexample.domain.person.BirthDate;
import com.bs.hzexample.domain.person.Email;
import com.bs.hzexample.domain.person.Person;
import com.bs.hzexample.domain.person.PersonId;
import com.bs.hzexample.domain.person.PersonName;
import com.bs.hzexample.domain.person.PhoneNumber;
import com.bs.hzexample.domain.person.Salutation;

import java.util.Calendar;
import java.util.Date;

public final class PersonFixture {

    public static Person getPerson(PersonId personId) {
        Salutation salutation = Salutation.MR;
        PersonName name = PersonName.builder().firstName("John").lastName("Doe").build();
        Date date = new Calendar.Builder()
                .setDate(1985, 01, 25)
                .build()
                .getTime();
        BirthDate birthDate = new BirthDate(date);
        Address address = Address.builder()
                .city("London")
                .country("United Kingdom")
                .street("Regent Street")
                .houseNumber("55")
                .postCode("W1B 2EL")
                .build();
        PhoneNumber phoneNumber = new PhoneNumber(44, "65161561");
        Email email = new Email("john.doe@gmail.com");
        return new Person(personId, salutation, name, birthDate, address, phoneNumber, email);
    }
}
