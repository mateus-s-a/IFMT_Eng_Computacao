package br.com.compracerta.sys.util.menu;

import br.com.compracerta.sys.util.Teclado;
import br.com.compracerta.sys.util.produto.Produto;

public class Menu {
    public static void exibirMenu(Produto[] produtos) {
        int opcao;

        do {
            System.out.println("\n --- SITEMA DE PRODUTOS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Alterar");
            System.out.println("4 - Consultar");
            System.out.println("0 - Encerrar");

            opcao = Teclado.lerInteiro("Escolha uma opção:");

            switch (opcao) {
                // cadastro
                case 1: {
                    Menu.exibirSubMenu();
                    break;
                }

                // excluir
                case 2: {

                    break;
                }

                // alterar
                case 3: {

                    break;
                }

                // consultar
                case 4: {

                    break;
                }

                // encerrar
                case 5: {
                    System.out.println("\nEncerrando programa...");
                    break;
                }

                default: {
                    System.out.println("\nOpção Inválida.\n");
                    break;
                }

            }
        } while (opcao != 0);
    }

    public static void exibirSubMenu() {
        int opcao;

        do {
            System.out.println("\n --- NACIONAL | INTERNACIONAL ---");
            System.out.println("1 - Nacional");
            System.out.println("2 - Internacional");

            opcao = Teclado.lerInteiro("Escolha um tipo: ");

            switch (opcao) {
                case 1: {

                    break;
                }

                case 2: {
                    break;
                }

                default: {
                    System.out.println("\nOpção Inválida.\n");
                    break;
                }
            }
        } while (opcao != 1 || opcao != 2);
    }
}
