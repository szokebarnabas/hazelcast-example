package com.bs.hzexample.util.ddd.model;

public abstract class Entity<T extends ID> implements Domain {

    private T id;

    protected Entity(final T id) {
        setID(id);
    }

    public /*final*/ T getID() {
        return id;
    }

    private void setID(final T id) {

        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.id = id;
    }

    @Override
    public final boolean equals(final Object other) {

        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Entity entity = (Entity) other;
        if (getID() != null ? !getID().equals(entity.getID()) : entity.getID() != null) {
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {

        return getID() != null ? getID().hashCode() : 0;
    }

    @Override
    public String toString() {

        return id.toString();
    }
}
