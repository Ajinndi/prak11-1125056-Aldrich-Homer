package model;

import java.util.List;

public class CreditCard implements PaymentStrategy {
    private String cardNumber;
    private double limit;
    private double currentDebt;
    private String ccv;
    private String pin;

    public CreditCard(String cardNumber, double limit, String ccv, String pin) {
        this.cardNumber = cardNumber;
        this.limit = limit;
        this.currentDebt = 0;
        this.ccv = ccv;
        this.pin = pin;
    }

    @Override
    public String getPaymentName() {
        return "Credit Card";
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && (currentDebt + amount) <= limit;
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100000 && amount <= 100000000 && validate(amount);
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) currentDebt += amount;
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(AuthorizationMethod.CCV, AuthorizationMethod.PIN);
    }

    @Override
    public boolean validateAuthorization(AuthorizationMethod method, String credential) {
        if (method == AuthorizationMethod.CCV) return ccv.equals(credential);

        if (method == AuthorizationMethod.PIN) return pin.equals(credential);

        return false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getLimit() {
        return limit;
    }

    public double getCurrentDebt() {
        return currentDebt;
    }
}