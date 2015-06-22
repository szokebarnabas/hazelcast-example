package com.bs.hzexample.domain.person;

import com.bs.hzexample.util.ddd.model.ValueObject;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
public class Email extends ValueObject implements Serializable {

    private final String email;

    public static Email createEmail(String email) {
        return new Email(email);
    }
}
