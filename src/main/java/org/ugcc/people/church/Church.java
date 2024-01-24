package org.ugcc.people.church;

import org.ugcc.people.common.Translation;

import java.util.Map;

public class Church {
    private final String id;

    private final String cityId;

    private final Map<String, String> name;

    public Church(String id, String cityId, String nameEng, String nameUkr) {
        this.id = "%s-%s".formatted(cityId, id);
        this.cityId = cityId;
        name = Translation.translationMap(nameEng, nameUkr);
    }

    public String getId() {
        return id;
    }

    public String getCityId() {
        return cityId;
    }

    public Map<String, String> getName() {
        return name;
    }
}
