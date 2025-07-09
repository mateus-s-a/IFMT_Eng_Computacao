package utils;

import java.util.Scanner;

public class Teclado {
    public static String setString(String mensagem) {
        System.out.println(mensagem);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static int setInt(String mensagem) {
        System.out.println(mensagem);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static double setDouble(String mensagem) {
        System.out.println(mensagem);
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }
}
