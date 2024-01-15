package org.ugcc.people.session;

public class LoginRequest {
    private String otp;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "otp='" + otp + '\'' +
                '}';
    }
}
