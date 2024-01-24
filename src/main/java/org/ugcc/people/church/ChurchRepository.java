package org.ugcc.people.church;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Component
public class ChurchRepository {
    private static Map<String, Map<String, Church>> churches = new HashMap<>();

    public ChurchRepository() {
        for (Church c : new Church[] {
            new Church("Mykolaya", "Ukraine-Ternopil",
                    "Saint Nicolas from Myra Lycian near the Psychiatry-Neurologic hospital",
                    "Святого Миколая Мирликійського на території Психоневрологічної лікарні"),
            new Church("Yosafata", "Ukraine-Kyiv",
                    "Sint Josafat nearby the Svyatoshyn metro station",
                    "Святого Йосафата поблизу станції метро Святошин"),
            new Church("MyhailaTaPetra", "Belgium-Antwerp",
                    "Sint Michael and Peter nearby the Montigny tram station",
                    "Святого Михаїла та Петра навпроти трамвайної зупинки Montigny")
        }) {
            Map<String, Church> cityChurches = churches.computeIfAbsent(
                c.getCityId(), k -> new HashMap<>()
            );
            cityChurches.put(c.getId(), c);
        }
    }

    public Collection<Church> all(String cityId) {
        return churches.get(cityId).values();
    }
}
