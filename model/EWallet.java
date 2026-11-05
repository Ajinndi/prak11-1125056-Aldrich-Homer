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
    public boolean validateAuthorization(AuthorizationMethod method, String credential) {
        switch (method) {
            case PIN:
                return pin.equals(credential);
            case OTP:
                return credential != null && credential.length() == 6;
            default:
                return false;
        }
    }

    @Override
    public String getPaymentName() {
        return "E-Wallet";
    }
}