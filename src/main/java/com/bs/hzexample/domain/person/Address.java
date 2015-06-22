package com.bs.hzexample.domain.person;

import com.bs.hzexample.util.ddd.model.ValueObject;
import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Address extends ValueObject implements Serializable {

    private final String country;
    private final String city;
    private final String postCode;
    private final String street;
    private final String houseNumber;
    private final String floor;
    private final String door;

    private Address(String country, String city, String postCode, String street, String houseNumber, String floor, String door) {
        Preconditions.checkNotNull(city, "City cannot be null");
        Preconditions.checkNotNull(postCode, "Post code cannot be null");
        Preconditions.checkNotNull(street, "Street cannot be null");
        Preconditions.checkNotNull(houseNumber, "House number cannot be null");
        this.country = country;
        this.city = city;
        this.postCode = postCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.door = door;
    }
}
