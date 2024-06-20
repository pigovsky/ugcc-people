package org.ugcc.people.person;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddPerson {
    private final String lastVisit;

    public AddPerson(@JsonProperty("lastVisit") String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastVisit() {
        return lastVisit;
    }
}
