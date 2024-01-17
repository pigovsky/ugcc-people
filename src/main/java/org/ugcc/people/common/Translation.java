package org.ugcc.people.common;

import java.util.HashMap;
import java.util.Map;

public class Translation {

    /**
     * Constructs a map with translations
     *
     * @param textEng text in English
     * @param textUkr its Ukrainian translation
     * @return map in the form of {"eng": "text in English", "ukr": "its Ukrainian translation"}
     */
    public static Map<String, String> translationMap(String textEng, String textUkr) {
        final Map<String, String> name;
        name = new HashMap<>();
        name.put("eng", textEng);
        name.put("ukr", textUkr);
        return name;
    }
}
