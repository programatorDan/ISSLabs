package org.example;

public class Entity<ID> {
    protected ID Id;

    public ID getId() {
        return Id;
    }

    public void setId(ID id) {
        Id = id;
    }
}
