package controller;

import model.PaymentStrategy;
import model.AuthorizationMethod;
import model.AuthorizationStrategy;
import exception.InvalidAuthorizationException;
import util.InputUtil;

import java.util.*;

public class PaymentProcessor {

    public void processPayment(PaymentStrategy strategy, double amount) {
        if (!strategy.validate(amount)) throw new IllegalArgumentException("Pembayaran tidak dapat diproses. Saldo atau limit tidak mencukupi.");

        List<AuthorizationMethod> authorizations = strategy.getRequiredAuthorizations();

        for (int i = 0; i < authorizations.size(); i++) {

            AuthorizationMethod method = authorizations.get(i);
            String credential = InputUtil.readString("Masukkan " + method + ": ");
            AuthorizationStrategy authStrategy = strategy.getAuthorizationStrategy(method);

            if (authStrategy == null || !authStrategy.validate(credential)) throw new InvalidAuthorizationException("Autentikasi " + method + " gagal!");
        }

        strategy.pay(amount);

        System.out.println("Pembayaran berhasil!");
    }
}