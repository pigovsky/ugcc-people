package org.ugcc.people.person;

import org.springframework.web.bind.annotation.*;
import org.ugcc.people.session.SessionService;
import org.ugcc.people.user.User;
import org.ugcc.people.user.UserRepository;

import java.util.Collection;
import java.util.Map;

@RestController
public class PersonController {
    private final SessionService sessionService;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public PersonController(SessionService sessionService, UserRepository userRepository, PersonRepository personRepository) {
        this.sessionService = sessionService;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @PostMapping("/api/v1/countries/{countryId}/cities/{cityId}/churches/{churchId}/people")
    private Person addPerson(
            @RequestHeader Map<String, String> headers,
            @PathVariable String countryId,
            @PathVariable String cityId,
            @PathVariable String churchId,
            @RequestBody AddPerson addPerson
    ) {
        String userId = sessionService.validateSession(headers);
        User user = userRepository.findUser(userId);
        Person person = new Person(userId, user.getFirstName(), addPerson.getLastVisit());
        return personRepository.addPerson(countryId, cityId, churchId, person);
    }

    @RequestMapping("/api/v1/countries/{countryId}/cities/{cityId}/churches/{churchId}/people")
    private Collection<Person> getPeople(
            @RequestHeader Map<String, String> headers,
            @PathVariable String countryId,
            @PathVariable String cityId,
            @PathVariable String churchId
    ) {
        sessionService.validateSession(headers);
        return personRepository.getPeople(countryId, cityId, churchId);
    }
}
