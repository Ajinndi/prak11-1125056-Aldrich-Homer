package controller;

import model.Wallet;
import model.DebitCard;
import model.CreditCard;
import view.PaymentView;

public class PaymentController {
    private Wallet wallet;
    private DebitCard debitCard;
    private CreditCard creditCard;
    private PaymentView view;

    public PaymentController() {
        wallet = new Wallet("Main Wallet", 10000);
        debitCard = new DebitCard("1234567890", 100000, "1234");
        creditCard = new CreditCard("9876543210", 500000, "123", "5678");
        view = new PaymentView();
    }

    public void start() {
        while (true) {
            double amount = view.inputAmount();
            int method = view.selectPaymentMethod();

            switch (method) {
                case 1:
                    if (wallet.validate(amount)) {
                        wallet.pay(amount);
                        view.showPaymentSuccess("cash", wallet.getCashValue());
                    } else {
                        view.showPaymentFailed();
                    }
                    break;

                case 2:
                    if (debitCard.validate(amount)) {
                        debitCard.pay(amount);
                        view.showPaymentSuccess("debit card", debitCard.getBalance());
                    } else {
                        view.showPaymentFailed();
                    }
                    break;

                case 3:
                    if (creditCard.validate(amount)) {
                        creditCard.pay(amount);
                        view.showCreditPaymentSuccess(creditCard.getCurrentDebt(), creditCard.getAvailableLimit());
                    } else {
                        view.showPaymentFailed();
                    }
                    break;

                default:
                    view.showInvalidPaymentMethod();
                    break;
            }
            System.out.println();
        }
    }
}