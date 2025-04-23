package sistemagestao;

import java.util.Scanner;

public class Teclado {
    // Scanner agora público ou default
    public Scanner scanner;

    // Construtor
    public Teclado() {
        scanner = new Scanner(System.in);
    }

    // Metodo para ler uma String (sem alterações significativas)
    public String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    // Metodo para ler um número inteiro (sem try-catch)
    // !! ATENÇÃO: Vai travar se o usuário não digitar um inteiro !!
    public int lerInt(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner (essencial após nextInt)
        return valor;
    }

    // Metodo para ler um número double (sem try-catch)
    public double lerDouble(String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer do scanner (essencial após nextDouble)
        return valor;
    }

    // Metodo para fechar o Scanner (sem alterações significativas)
    public void fechar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
