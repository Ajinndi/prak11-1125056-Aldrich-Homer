import controller.PaymentController;
import util.InputUtil;

public class App {
    public static void main(String[] args) {
        PaymentController controller = new PaymentController();
        
        int choice;

        do {
            System.out.println("Dynamic payment system");
            System.out.println("1. Bikin Pembayaran");
            System.out.println("2. Tambah Pembayaran");
            System.out.println("0. Keluar");

            choice = InputUtil.readInt("Pilih menu: ");

            switch (choice) {
                case 1:
                    controller.makePayment();
                    break;

                case 2:
                    controller.addPaymentMethod();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }

        } while (choice != 0);
    }
}