package br.com.compracerta.sys.util;

import java.util.Scanner;

public class Teclado {
    public static int lerInteiro(String mensagem) {
        System.out.println(mensagem);
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static double lerDouble(String mensagem) {
        System.out.println(mensagem);
        Scanner s = new Scanner(System.in);
        return s.nextDouble();
    }

    public static String lerString(String mensagem) {
        System.out.println(mensagem);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}
