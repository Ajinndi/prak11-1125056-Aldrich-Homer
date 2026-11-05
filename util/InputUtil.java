package util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static int readInt(String message) {
        System.out.print(message);
        return Integer.parseInt(sc.nextLine());
    }

    public static double readDouble(String message) {
        System.out.print(message);
        return Double.parseDouble(sc.nextLine());
    }

    public static String readString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}