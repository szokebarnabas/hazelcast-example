package com.bs.hzexample.util.ddd.model;

public class AggregateRoot<T extends ID> extends Entity<T>{

    protected AggregateRoot(T id) {
        super(id);
    }
}
