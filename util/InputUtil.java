package util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static int readInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    public static double readDouble(String message) {
        System.out.print(message);
        return sc.nextDouble();
    }

    public static String readLine(String message) {
        System.out.print(message);
        return sc.next();
    }
}