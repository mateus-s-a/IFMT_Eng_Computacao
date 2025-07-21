package br.com.website.sys.test;

import br.com.website.sys.app.JogoApp;
import br.com.website.sys.utils.Teclado;

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
                case 2:
                    sistema.realizarVenda();
                case 3:
                    sistema.listarJogos();
                case 4:
                    System.out.println("\nSaindo...");
                default:
                    System.out.println("\n\t> Erro: opção inválida"); // '\n' '\t' caracteres de escape para break-row e tab, respectivamente
            }
        } while (opcao != 4);
    }
}
