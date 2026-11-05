package model;

import java.util.*;

public class Wallet implements PaymentStrategy {
    private String name;
    private double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    @Override
    public String getPaymentName() {
        return "Wallet";
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && cashValue >= amount;
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100 && amount <= 1000000 && validate(amount);
    }

    @Override
    public void pay(double amount) {
        if (validate(amount)) cashValue -= amount;
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of();
    }

    @Override
    public boolean validateAuthorization(AuthorizationMethod method, String credential) {
        return false;
    }

    public String getName() {
        return name;
    }

    public double getCashValue() {
        return cashValue;
    }
}