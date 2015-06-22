package com.bs.hzexample.util.ddd.model;

public class DomainException extends RuntimeException {

    private ID id;

    public DomainException(ID id, String message) {
        super(message);
        this.id = id;
    }

    public ID getId() {
        return id;
    }
}
