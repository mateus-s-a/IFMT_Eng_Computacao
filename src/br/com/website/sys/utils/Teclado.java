package br.com.website.sys.utils;

import java.util.Scanner;

public class Teclado {
    public static String lerString(String mensagem) {
        Scanner scan = new Scanner(System.in);
        System.out.println(mensagem);
        return scan.nextLine();
    }

    public static double lerInt(String mensagem) {
        Scanner scan = new Scanner(System.in);
        System.out.println(mensagem);
        return scan.nextInt();
    }

    public static double lerDouble(String mensagem) {
        Scanner scan = new Scanner(System.in);
        System.out.println(mensagem);
        return scan.nextDouble();
    }
}
