package org.ugcc.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ugcc.people.chatbot.telegram.TelegramChatbot;
import org.ugcc.people.session.LoginRequest;
import org.ugcc.people.session.LoginResponse;
import org.ugcc.people.session.SessionService;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@RestController
@SpringBootApplication
public class Main {
    private final SessionService sessionService;

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.setProperty("server.servlet.register-default-servlet", "true");
        SpringApplication.run(Main.class, args);
    }

    public Main(TelegramChatbot telegramChatbot, SessionService sessionService){
        this.sessionService = sessionService;
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
}
