package org.ugcc.people.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.ugcc.people.otp.OtpService;
import org.ugcc.people.user.User;
import org.ugcc.people.user.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class SessionService {
    private Logger logger = LoggerFactory.getLogger(SessionService.class);

    private static Map<String, String> sessions = new HashMap<>();

    private final OtpService otpService;

    private final UserRepository userRepository;

    public SessionService(OtpService otpService, UserRepository userRepository) {
        this.otpService = otpService;
        this.userRepository = userRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        logger.info("Login entity {}", loginRequest);
        String userId = otpService.consumeOtp(loginRequest.getOtp());
        User user = userRepository.findUser(userId);
        if (user != null) {
            String sessionKey = UUID.randomUUID().toString();
            sessions.put(sessionKey, userId);
            return new LoginResponse(sessionKey, user);
        }
        throw new LoginError("Wrong OTP");
    }

    /**
     * Checks if given session key is valid.
     * If it is valid, then does nothing.
     * If invalid, then throws an InvalidSessionError.
     *
     * @param headers HTTP headers map
     */
    public void hasSession(Map<String, String> headers) {
        logger.info("HTTP headers: {}", headers);
        if (sessions.get(headers.get("session-key")) == null) {
            throw new InvalidSessionError();
        }
    }
}
