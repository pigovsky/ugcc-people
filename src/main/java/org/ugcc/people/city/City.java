package org.ugcc.people.city;

import org.ugcc.people.common.Translation;

import java.util.Map;

public class City {
    private final String id;

    private final String countryId;

    private final Map<String, String> name;

    public City(String countryId, String nameEng, String nameUkr) {
        id = "%s-%s".formatted(
            countryId,
            nameEng.replaceAll("\\s+", "")
        );
        this.countryId = countryId;
        name = Translation.translationMap(nameEng, nameUkr);
    }

    public String getId() {
        return id;
    }

    public String getCountryId() {
        return countryId;
    }

    public Map<String, String> getName() {
        return name;
    }
}
