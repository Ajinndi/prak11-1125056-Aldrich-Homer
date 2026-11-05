package controller;

import model.Wallet;
import view.PaymentView;

public class PaymentController {
    private Wallet wallet;
    private PaymentView view;

    public PaymentController() {
        wallet = new Wallet("Main Wallet", 10000);
        view = new PaymentView();
    }

    public void start() {
        while (true) {
            double amount = view.inputAmount();

            if (wallet.validate(amount)) {
                wallet.pay(amount);
                view.showPaymentSuccess(wallet.getCashValue());
            } else {
                view.showPaymentFailed();
            }
        }
    }
}