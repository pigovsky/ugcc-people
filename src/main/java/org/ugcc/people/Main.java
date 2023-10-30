package org.ugcc.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ugcc.people.chatbot.telegram.TelegramChatbot;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@RestController
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.setProperty("server.servlet.register-default-servlet", "true");
        SpringApplication.run(Main.class, args);
    }

    public Main(TelegramChatbot telegramChatbot){
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
}
