package controller;

import model.PaymentStrategy;
import model.AuthorizationMethod;
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

            if (!strategy.validateAuthorization(method, credential)) throw new InvalidAuthorizationException("Autentikasi " + method + " gagal!");
        }

        strategy.pay(amount);

        System.out.println("Pembayaran berhasil!");
    }
}