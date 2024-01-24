package org.ugcc.people.church;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ugcc.people.session.SessionService;

import java.util.Collection;
import java.util.Map;

@RestController
public class ChurchController {
    private final ChurchRepository churchRepository;

    private final SessionService sessionService;

    public ChurchController(ChurchRepository churchRepository, SessionService sessionService){
        this.churchRepository = churchRepository;
        this.sessionService = sessionService;
    }

    @RequestMapping("/api/v1/countries/{countryId}/cities/{cityId}/churches")
    private Collection<Church> churches(
        @RequestHeader Map<String, String> headers,
        @PathVariable String countryId,
        @PathVariable String cityId
    ) {
        sessionService.validateSession(headers);
        return churchRepository.all("%s-%s".formatted(countryId, cityId));
    }
}
