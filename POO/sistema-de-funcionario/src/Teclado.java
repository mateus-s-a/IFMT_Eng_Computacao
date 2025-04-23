import java.util.Scanner;

public class Teclado {
    public static int lerInteiro(String mensagem) {
        System.out.println(mensagem);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static double lerDouble(String mensagem) {
        System.out.println(mensagem);
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    public static String lerString(String mensagem) {
        System.out.println(mensagem);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
