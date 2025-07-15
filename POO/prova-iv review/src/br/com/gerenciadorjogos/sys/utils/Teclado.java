package br.com.gerenciadorjogos.sys.utils;

import java.util.Scanner;

public class Teclado {
    public static String lerString(String mensagem) {
        System.out.println(mensagem);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.println(mensagem);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static double lerDouble(String mensagem) {
        System.out.println(mensagem);
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }
}
