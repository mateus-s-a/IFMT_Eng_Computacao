package br.com.gerenciadorjogos.sys.test;

import br.com.gerenciadorjogos.sys.app.JogoApp;
import br.com.gerenciadorjogos.sys.utils.Teclado;

public class Main {
    public static void main(String[] args) {
        JogoApp sistema = new JogoApp();

        int opcao;

        do {
            System.out.println("\n\t === SISTEMA GERENCIADOR DE JOGOS ===\n");
            System.out.println("1. Cadastrar Jogo (físico/digital)");
            System.out.println("2. Vender Jogo");
            System.out.println("3. Listar Jogos");
            System.out.println("4. Encerrar...");
            opcao = Teclado.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    sistema.cadastrarJogo();
                    break;
                case 2:
                    sistema.realizarVenda();
                    break;
                case 3:
                    sistema.listarJogos();
                    break;
                case 4:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\n\t> Erro: opção inválida");
            }
        } while (opcao != 4);
    }
}
