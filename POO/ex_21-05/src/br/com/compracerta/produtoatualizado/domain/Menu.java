package br.com.compracerta.produtoatualizado.domain;

public class Menu {
    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("===// MENU //===");
            System.out.print("\n");
            System.out.println("1. Inserir Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Consultar Produto");
            System.out.println("5. Encerrar");
            System.out.print("\n");
            System.out.println("Opção: ");
            opcao = Teclado.scanInt();

            switch (opcao) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                default:
                    System.out.print("\n");
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (opcao != 0);
    }
}
