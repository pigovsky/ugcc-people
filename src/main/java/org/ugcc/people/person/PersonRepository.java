package org.ugcc.people.person;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {
    private final Map<String, Map<String, Map<String, Map<String, Person>>>> people = new HashMap<>();

    public Person addPerson(String countryId, String cityId, String churchId, Person person) {
        Map<String, Map<String, Map<String, Person>>> peopleByCountry = people.computeIfAbsent(countryId, k -> new HashMap<>());
        Map<String, Map<String, Person>> peopleByCity = peopleByCountry.computeIfAbsent(cityId, k -> new HashMap<>());
        Map<String, Person> peopleByChurch = peopleByCity.computeIfAbsent(churchId, k -> new HashMap<>());
        peopleByChurch.put(person.getId(), person.setUpdated());
        return person;
    }

    public Collection<Person> getPeople(String countryId, String cityId, String churchId) {
        Map<String, Map<String, Map<String, Person>>> peopleByCountry = people.get(countryId);
        if (peopleByCountry == null) {
            return null;
        }
        Map<String, Map<String, Person>> peopleByCity = peopleByCountry.get(cityId);
        if (peopleByCity == null) {
            return null;
        }
        Map<String, Person> peopleByChurch = peopleByCity.get(churchId);
        if (peopleByChurch == null) {
            return null;
        }
        return peopleByChurch.values();
    }
}
