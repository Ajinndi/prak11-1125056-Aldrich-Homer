package view;

import util.InputUtil;

public class PaymentView {

    public double inputAmount() {
        return InputUtil.readDouble("Masukkan jumlah yang dibayar: ");
    }

    public void showPaymentSuccess(double remainingBalance) {
        System.out.println(
            "Pembayaran cash berhasil, sisa wallet: " + remainingBalance
        );
    }

    public void showPaymentFailed() {
        System.out.println("Pembayaran gagal! Saldo tidak mencukupi.");
    }
}