package model;

public class CreditCard {
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

    public boolean validate(double amount) {
        return amount > 0 && (currentDebt + amount) <= limit;
    }

    public void pay(double amount) {
        if (validate(amount)) {
            currentDebt += amount;
        }
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

    public double getAvailableLimit() {
        return limit - currentDebt;
    }
}