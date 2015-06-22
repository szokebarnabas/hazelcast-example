package com.bs.hzexample.domain.person;

import com.bs.hzexample.util.ddd.model.ValueObject;
import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PersonName extends ValueObject implements Serializable {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    private PersonName(String firstName, String middleName, String lastName) {
        Preconditions.checkNotNull(firstName, "First name cannot be null");
        Preconditions.checkNotNull(lastName, "Last name cannot be null");
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}