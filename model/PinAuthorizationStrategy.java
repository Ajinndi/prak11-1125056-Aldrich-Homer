package model;

public class PinAuthorizationStrategy implements AuthorizationStrategy {
    private String pin;

    public PinAuthorizationStrategy(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean validate(String credential) {
        return pin.equals(credential);
    }
}