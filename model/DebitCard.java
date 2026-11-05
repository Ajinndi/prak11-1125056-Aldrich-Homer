package model;

public class DebitCard {
    private String cardNumber;
    private double balance;
    private String pin;

    public DebitCard(String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validate(double amount) {
        return amount > 0 && balance >= amount;
    }

    public void pay(double amount) {
        if (validate(amount)) {
            balance -= amount;
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }
}