package org.ugcc.people.chatbot.telegram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.ugcc.people.chatbot.telegram.models.*;
import org.ugcc.people.otp.OtpService;
import org.ugcc.people.user.User;
import org.ugcc.people.user.UserRepository;

@Component
public class TelegramChatbot implements Runnable {
    private Logger logger = LoggerFactory.getLogger(TelegramChatbot.class);

    private final String baseUri;

    private final GetUpdateRequest getUpdateRequest = new GetUpdateRequest();

    private final RestTemplate restTemplate = new RestTemplate();

    private final OtpService otpService;
    private final UserRepository userRepository;

    private static final String otpEng = "otp";

    private static final String otpUkr = "оп";

    public TelegramChatbot(OtpService otpService, UserRepository userRepository) {
        this.baseUri = "https://api.telegram.org/%s"
                .formatted(System.getenv("telegram_bot_token"));
        this.otpService = otpService;
        this.userRepository = userRepository;
    }

    @Override
    public void run() {
        while (true) {
            UpdatesResponse response = restTemplate.postForObject(this.baseUri + "/getUpdates", getUpdateRequest, UpdatesResponse.class);
            for (UpdateResponse u : response.getResult()) {
//                this.logger.info("offset {}: {}", getUpdateRequest.getOffset(), u);
                String command = u.getMessage().getText();
                TelegramUser telegramUser = u.getMessage().getFrom();
                String fullName = telegramUser.getFullName();
                logger.info("Message {} from {}", command, fullName);
                String userId = telegramUser.getExternalId();

                boolean isUkrOtpCommand = otpUkr.equalsIgnoreCase(command);
                if (otpEng.equalsIgnoreCase(command) || isUkrOtpCommand) {
                    User user = userRepository.findUser(userId);
                    long chatId = u.getMessage().getChat().getId();
                    if (user == null) {
                        user = User.fromTelegramUser(telegramUser);
                        String lang = otpEng.equalsIgnoreCase(command) ? "ukr" : "eng";
                        user.setLanguage(lang);
                        user.setTelegramChatId(chatId);
                        userRepository.addUser(user);
                    }
                    String otp = otpService.generateOtp(userId);
                    String otpMessageFromBot = "Thank you, %s, for taking part in the UGCC People network. Your OTP is %s"
                            .formatted(
                                    telegramUser.getFirstName(),
                                    otp
                            );
                    sendTextMessage(chatId, otpMessageFromBot);
                }

                getUpdateRequest.setOffset(u.getUpdateId() + 1);
            }
        }
    }

    /**
     * Sends given text message to the specified chat
     *
     * @param chatId chat identifier to send the message to
     * @param text the message text
     */
    private void sendTextMessage(long chatId, String text) {
        restTemplate.postForObject(
                this.baseUri + "/sendMessage",
                new MessageRequest(
                        chatId,
                        text
                ),
                Object.class
        );
    }
}
