package com.bs.hzexample.domain.person;

import com.bs.hzexample.util.ddd.model.ValueObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class PhoneNumber extends ValueObject implements Serializable {

    private final Integer countryCode;
    private final String phoneNumber;
}
