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
        return InputUtil.readInt("Pilihan: ");
    }

    public void showPaymentSuccess(String method, double remainingBalance) {
        System.out.println("Pembayaran " + method + " berhasil, sisa saldo: " + remainingBalance);
    }

    public void showPaymentFailed() {
        System.out.println("Pembayaran gagal! Saldo tidak mencukupi.");
    }

    public void showInvalidPaymentMethod() {
        System.out.println("Pilihan metode pembayaran tidka valid.");
    }
}