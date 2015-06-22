package com.bs.hzexample.domain.person;


import com.bs.hzexample.util.ddd.model.ID;

public class PersonId extends ID {

    protected PersonId(String value) {
        super(value);
    }

    public static PersonId createFrom(String id) {
        return new PersonId(id);
    }

}
