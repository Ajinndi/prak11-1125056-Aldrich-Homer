package view;

import util.InputUtil;

public class PaymentView {

    public double inputAmount() {
        return InputUtil.readDouble("Masukkan jumlah yang dibayar: ");
    }

    public int selectPaymentMethod() {
        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Cash");
        System.out.println("2. Debit Card");
        System.out.println("3. Credit Card");
        return InputUtil.readInt("Pilihan: ");
    }

    public void showPaymentSuccess(String method, double remainingBalance) {
        System.out.println("Pembayaran " + method + " berhasil, sisa saldo: " + remainingBalance);
    }

    public void showPaymentSuccess(double currentDebt, double availableLimit) {
        System.out.println("Pembayaran kredit berhasil.");
        System.out.println("Total uang: " + currentDebt);
        System.out.println("Sisa limit kredit: " + availableLimit);
    }

    public void showCreditPaymentSuccess(double currentDebt, double availableLimit) {
        System.out.println("Pembayaran credit berhasil!");
        System.out.println("Total utang: " + currentDebt);
        System.out.println("Sisa limit kredit: " + availableLimit);
    }

    public void showPaymentFailed() {
        System.out.println("Pembayaran gagal.");
    }

    public void showInvalidPaymentMethod() {
        System.out.println("Pilihan metode pembayaran tidka valid.");
    }
}