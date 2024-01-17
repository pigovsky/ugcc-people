package org.ugcc.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.ugcc.people.chatbot.telegram.TelegramChatbot;
import org.ugcc.people.city.City;
import org.ugcc.people.city.CityRepository;
import org.ugcc.people.country.Country;
import org.ugcc.people.country.CountryRepository;
import org.ugcc.people.session.LoginRequest;
import org.ugcc.people.session.LoginResponse;
import org.ugcc.people.session.SessionService;

import java.util.Collection;
import java.util.Map;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@RestController
@SpringBootApplication
public class Main {
    private final SessionService sessionService;

    private final CountryRepository countryRepository;

    private final CityRepository cityRepository;

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.setProperty("server.servlet.register-default-servlet", "true");
        SpringApplication.run(Main.class, args);
    }

    public Main(TelegramChatbot telegramChatbot, SessionService sessionService, CountryRepository countryRepository, CityRepository cityRepository){
        this.sessionService = sessionService;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
        new Thread(telegramChatbot).start();
    }

    @RequestMapping("/hello")
    private static String hello() {
        StringBuilder val = new StringBuilder("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            val.append("i = " + i);
        }
        return val.toString();
    }

    @PostMapping("/api/v1/login")
    private LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return sessionService.login(loginRequest);
    }

    @RequestMapping("/api/v1/countries")
    private Collection<Country> countries(@RequestHeader Map<String, String> headers) {
        sessionService.validateSession(headers);
        return countryRepository.all();
    }

    @RequestMapping("/api/v1/countries/{countryId}/cities")
    private Collection<City> cities(@RequestHeader Map<String, String> headers, @PathVariable String countryId) {
        sessionService.validateSession(headers);
        return cityRepository.all(countryId);
    }
}
