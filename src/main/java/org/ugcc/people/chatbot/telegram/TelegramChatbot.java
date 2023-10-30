package org.ugcc.people.chatbot.telegram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.ugcc.people.chatbot.telegram.models.GetUpdateRequest;
import org.ugcc.people.chatbot.telegram.models.MessageRequest;
import org.ugcc.people.chatbot.telegram.models.UpdateResponse;
import org.ugcc.people.chatbot.telegram.models.UpdatesResponse;
import org.ugcc.people.otp.OtpRepository;

import java.util.Optional;

@Component
public class TelegramChatbot implements Runnable {
    private Logger logger = LoggerFactory.getLogger(TelegramChatbot.class);

    private final String baseUri;

    private final GetUpdateRequest getUpdateRequest = new GetUpdateRequest();

    private final RestTemplate restTemplate = new RestTemplate();

    private final OtpRepository otpRepository;

    public TelegramChatbot(OtpRepository otpRepository) {
        this.baseUri = "https://api.telegram.org/%s"
                .formatted(System.getenv("telegram_bot_token"));
        this.otpRepository = otpRepository;
    }

    @Override
    public void run() {
        while (true) {
            UpdatesResponse response = restTemplate.postForObject(this.baseUri + "/getUpdates", getUpdateRequest, UpdatesResponse.class);
            for (UpdateResponse u : response.getResult()) {
//                this.logger.info("offset {}: {}", getUpdateRequest.getOffset(), u);
                String text = u.getMessage().getText();
                String fullName = u.getMessage().getFrom().getFullName();
                logger.info("Message {} from {}", text, fullName);
                String userId = "telegram" + u.getMessage().getFrom().getId();

                if ("otp".equalsIgnoreCase(text)) {
                    String otp = otpRepository.generateOtp(userId);
                    restTemplate.postForObject(
                            this.baseUri + "/sendMessage",
                            new MessageRequest(
                                u.getMessage().getChat().getId(),
                                "Dear %s, your OTP is %s. Thank you for using 'UGCC People' App"
                                    .formatted(
                                        fullName,
                                        otp
                                    )
                            ),
                            Object.class
                    );
                }

                getUpdateRequest.setOffset(u.getUpdateId() + 1);
            }
        }
    }
}
