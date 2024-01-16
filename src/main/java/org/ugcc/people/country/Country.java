package org.ugcc.people.country;

import java.util.HashMap;
import java.util.Map;

public class Country {
    private final String id;
    private final Map<String, String> name;

    public Country(String nameEng, String nameUkr) {
        this.id = nameEng.replaceAll("\\s+", "");
        this.name = new HashMap<>();
        this.name.put("eng", nameEng);
        this.name.put("ukr", nameUkr);
    }

    public String getId() {
        return id;
    }

    public Map<String, String> getName() {
        return name;
    }
}
