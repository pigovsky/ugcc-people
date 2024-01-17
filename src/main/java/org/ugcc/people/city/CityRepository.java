package org.ugcc.people.city;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Component
public class CityRepository {
    private static Map<String, Map<String, City>> cities = new HashMap<>();

    public CityRepository() {
        for (City c : new City[] {
            new City("Ukraine", "Kyiv", "Київ"),
            new City("Ukraine", "Ternopil", "Тернопіль"),
            new City("Belgium", "Antwerp", "Антверпен")
        }) {
            cities.putIfAbsent(c.getCountryId(), new HashMap<>());
            Map<String, City> citiesOfCountry = cities.get(c.getCountryId());
            citiesOfCountry.put(c.getId(), c);
        }
    }

    public Collection<City> all(String countryId) {
        return cities.get(countryId).values();
    }
}
