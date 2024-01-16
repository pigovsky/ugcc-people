package org.ugcc.people.country;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Component
public class CountryRepository {
    private static Map<String, Country> countries = new HashMap<>();

    public CountryRepository() {
        for (Country c : new Country[] {
            new Country("Ukraine", "Україна"),
            new Country("Belgium", "Бельгія")
        }) {
            countries.put(c.getId(), c);
        }
    }

    public Collection<Country> all() {
        return countries.values();
    }
}
