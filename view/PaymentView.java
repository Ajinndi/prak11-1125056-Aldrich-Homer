package view;

import model.PaymentStrategy;
import java.util.*;

public class PaymentView {

    public void showMainMenu() {
        System.out.println("Dynamic payment system");
        System.out.println("1. Bikin Pembayaran");
        System.out.println("2. Tambah Pembayaran");
        System.out.println("0. Keluar");
    }

    public void showPaymentMethods(List<PaymentStrategy> methods) {
        System.out.println("Metode pembayaran");

        for (int i = 0; i < methods.size(); i++) {
            System.out.println((i + 1) + ". " + methods.get(i).getClass().getSimpleName());
        }
    }

    public void showAddPaymentMenu() {
        System.out.println("Tambah metode pembayaran");
        System.out.println("1. Wallet");
        System.out.println("2. Debit Card");
        System.out.println("3. Credit Card");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}