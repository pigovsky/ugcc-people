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
        otps.put(otp, userId);
        return otp;
    }

    /**
     * Checks if otp is valid and returns appropriate user id
     * that is associated with it.
     *
     * @param otp one-time password string
     * @return user id associated with the otp if otp is
     * correct, or null otherwise
     */
    public String consumeOtp(String otp) {
        return otps.remove(otp);
    }
}
