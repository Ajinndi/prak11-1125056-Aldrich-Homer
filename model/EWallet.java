package model;

import java.util.List;

public class EWallet implements PaymentStrategy {
    private String phoneNumber;
    private double balance;
    private String pin;

    public EWallet(String phoneNumber, double balance, String pin) {
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public boolean validate(double amount) {
        return phoneNumber != null && !phoneNumber.isEmpty() && pin != null && !pin.isEmpty() && amount > 0 && amount <= balance;
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100 && amount <= 1000000 && amount <= balance;
    }

    @Override
    public void pay(double amount) {
        balance -= amount;
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(AuthorizationMethod.PIN, AuthorizationMethod.OTP);
    }

    @Override
    public AuthorizationStrategy getAuthorizationStrategy(AuthorizationMethod method) {
        switch (method) {
            case PIN:
                return new PinAuthorizationStrategy(pin);
            case OTP:
                return new OtpAuthorizationStrategy();
            default:
                return null;
        }
    }

    @Override
    public String getPaymentName() {
        return "E-Wallet";
    }
}