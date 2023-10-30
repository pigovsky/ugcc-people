package org.ugcc.people.otp;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Component
public class OtpRepository {
    private Random random = new Random();

    private Map<String, String> otps = new HashMap();

    public String generateOtp(String userId) {
        String otp = "%06d".formatted(random.nextInt(1000000));
        otps.put(userId, otp);
        return otp;
    }

    public boolean isValidOtp(String userId, String otp) {
        return otp.equals(otps.get(userId));
    }
}
