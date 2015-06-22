package com.bs.hzexample.domain.person;

import com.bs.hzexample.util.ddd.model.AggregateRoot;
import com.google.common.base.Preconditions;

public class Person extends AggregateRoot<PersonId> {

    private Salutation salutation;
    private PersonName name;
    private BirthDate birthDate;
    private Address address;
    private PhoneNumber phoneNumber;
    private Email email;

    public Person(PersonId id, Salutation salutation, PersonName name, BirthDate birthDate, Address address, PhoneNumber phoneNumber, Email email) {
        super(id);
        Preconditions.checkNotNull(salutation, "Salutation cannot be null!");
        Preconditions.checkNotNull(name, "Name cannot be null!");
        Preconditions.checkNotNull(birthDate, "Birth date cannot be null!");
        Preconditions.checkNotNull(address, "Address cannot be null!");
        Preconditions.checkNotNull(phoneNumber, "Phone number cannot be null!");
        Preconditions.checkNotNull(email, "Email number cannot be null!");
        this.salutation = salutation;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public PersonName getName() {
        return name;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public Email getEmail() {
        return email;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public void changePhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void changeBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
    }

    public void changeName(PersonName name) {
        this.name = name;
    }

    public void changeEmail(Email email) {
        this.email = email;
    }

}
