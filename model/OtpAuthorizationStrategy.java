package model;

public class OtpAuthorizationStrategy implements AuthorizationStrategy {
    @Override
    public boolean validate(String credential) {
        return credential != null && credential.matches("\\d{6}");
    }
}