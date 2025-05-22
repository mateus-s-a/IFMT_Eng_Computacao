package br.com.compracerta.produtos.servicos;

import java.util.Scanner;

public class Teclado {
    static Scanner input = new Scanner(System.in);

    public static int scanInt() {
        return input.nextInt();
    }

    public static String scanString() {
        return input.nextLine();
    }

    public static double scanDouble() {
        return input.nextDouble();
    }

    public static void nextLine() {
        input.nextLine();
    }
}