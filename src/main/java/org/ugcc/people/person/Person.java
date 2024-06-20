package org.ugcc.people.person;

import java.util.Date;

public class Person {
    private final String id;
    private final String name;
    private final String lastVisit;
    private Date updatedAt;

    public Person(String id, String name, String lastVisit) {
        this.id = id;
        this.name = name;
        this.lastVisit = lastVisit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public Person setUpdated() {
        this.updatedAt = new Date();
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
