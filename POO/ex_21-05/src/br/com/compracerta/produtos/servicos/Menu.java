package br.com.compracerta.produtos.servicos;

public class Menu {
    private ProdutoManager produtoManager;

    public Menu(ProdutoManager produtoManager) {
        this.produtoManager = produtoManager;
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("===// MENU //===");
            System.out.print("\n");
            System.out.println("1. Inserir Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Consultar Produto");
            System.out.println("5. Exibir Qtd. Total Estoque");
            System.out.println("0. Encerrar");
            System.out.print("\n");
            System.out.print("Opção: ");
            opcao = Teclado.scanInt();

            switch (opcao) {
                case 1:
                    produtoManager.inserirProduto();
                    break;

                case 2:
                    produtoManager.alterarProduto();
                    break;

                case 3:
                    produtoManager.excluirProduto();
                    break;

                case 4:
                    produtoManager.consultarTodosProdutos();
                    break;

                case 5:
                    System.out.printf("\nQtd. Estoque Total = %d unidades\n\n", produtoManager.getValorTotalEstoque());
                    break;

                case 0:
                    System.out.print("\n");
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.print("\n");
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }
}
