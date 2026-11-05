package model;

import java.util.*;

public class DebitCard implements PaymentStrategy {
    private String cardNumber;
    private double balance;
    private String pin;

    public DebitCard(String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public String getPaymentName() {
        return "Debit Card";
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && balance >= amount;
    }

    @Override
    public boolean canPay(double amount) {
        return amount > 0 && amount <= 10000000 && validate(amount);
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) balance -= amount;
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(AuthorizationMethod.PIN);
    }

    @Override
    public AuthorizationStrategy getAuthorizationStrategy(AuthorizationMethod method) {
        if (method == AuthorizationMethod.PIN) return new PinAuthorizationStrategy(pin);

        return null;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }
}