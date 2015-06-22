package com.bs.hzexample.domain.person;

import com.bs.hzexample.util.ddd.model.ValueObject;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BirthDate extends ValueObject implements Serializable {

    private final Date birthDate;
}
