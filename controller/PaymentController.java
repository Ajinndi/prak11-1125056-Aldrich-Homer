package controller;

import model.Wallet;
import model.DebitCard;
import model.CreditCard;
import model.PaymentStrategy;
import model.AuthorizationMethod;
import exception.InvalidAuthorizationException;
import util.InputUtil;
import view.PaymentView;

import java.util.*;

public class PaymentController {
    private List<PaymentStrategy> paymentMethods;
    private PaymentProcessor processor;
    private PaymentView view;

    public PaymentController() {
        paymentMethods = new ArrayList<>();
        processor = new PaymentProcessor();
        view = new PaymentView();
    }

    public void makePayment() {
        double amount = InputUtil.readDouble("Masukkan nominal pembayaran: ");

        List<PaymentStrategy> availableMethods = new ArrayList<>();

        for (int i = 0; i < paymentMethods.size(); i++) {
            PaymentStrategy method = paymentMethods.get(i);

            if (method.canPay(amount)) availableMethods.add(method);
        }

        if (availableMethods.isEmpty()) {
            view.showMessage("Tidak ada metode pembayaran yang tersedia untuk nominal tersebut.");
            return;
        }

        view.showPaymentMethods(availableMethods);

        int choice = InputUtil.readInt("Pilih metode pembayaran: ");

        if (choice < 1 || choice > availableMethods.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        PaymentStrategy selectedMethod = availableMethods.get(choice - 1);

        try {
            processor.processPayment(selectedMethod, amount);
        } catch (InvalidAuthorizationException | IllegalArgumentException e) {
            System.out.println("Pembayaran gagal: " + e.getMessage());
        }
    }

    public void addPaymentMethod() {
        view.showAddPaymentMenu();

        int choice = InputUtil.readInt("Pilih jenis pembayaran: ");

        switch (choice) {
            case 1:
                addWallet();
                break;

            case 2:
                addDebitCard();
                break;

            case 3:
                addCreditCard();
                break;

            default:
                view.showMessage("Pilihan tidak ada.");
        }
    }

    private void addWallet() {
        String name = InputUtil.readString("Masukkan nama Wallet: ");

        double balance = InputUtil.readDouble("Masukkan saldo Wallet: ");

        paymentMethods.add(new Wallet(name, balance));

        view.showMessage("Wallet berhasil ditambahkan!");
    }

    private void addDebitCard() {
        String cardNumber = InputUtil.readString("Masukkan nomor Debit Card: ");

        double balance = InputUtil.readDouble("Masukkan saldo Debit Card: ");

        String pin = InputUtil.readString("Masukkan PIN: ");

        paymentMethods.add(new DebitCard(cardNumber, balance, pin));

        view.showMessage("Debit Card berhasil ditambahkan!");
    }

    private void addCreditCard() {
        String cardNumber = InputUtil.readString("Masukkan nomor Credit Card: ");

        double limit = InputUtil.readDouble("Masukkan limit Credit Card: ");

        String ccv = InputUtil.readString("Masukkan CCV: ");

        String pin = InputUtil.readString("Masukkan PIN: ");

        paymentMethods.add(new CreditCard(cardNumber, limit, ccv, pin));

        view.showMessage("Credit Card berhasil ditambahkan!");
    }
}