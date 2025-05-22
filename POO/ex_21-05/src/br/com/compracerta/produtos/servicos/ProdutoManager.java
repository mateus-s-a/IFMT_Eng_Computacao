package br.com.compracerta.produtos.servicos;

import br.com.compracerta.produtos.modelo.Produto;

public class ProdutoManager {
    private final Produto[] produtos;
    private int totalDeProdutos;
    private int capacidade;

    public ProdutoManager(int capacidade) {
        this.capacidade = capacidade;
        this.produtos = new Produto[capacidade];
        this.totalDeProdutos = 0;
    }

    public void inserirProduto() {
        if (totalDeProdutos >= capacidade) {
            System.out.println("Capacidade máxima de produtos atingida.");
            return;
        }

        System.out.print("\n");
        System.out.println("=== Inserção de Produto ===");
        System.out.print("Preço: ");
        double precoAux = Teclado.scanDouble();
        Teclado.nextLine();

        System.out.print("Descrição: ");
        String descricaoAux = Teclado.scanString();

        System.out.print("Qtd. Estoque: ");
        int qtdEstoqueAux = Teclado.scanInt();
        Teclado.nextLine();

        int idAux = totalDeProdutos + 1;
        Produto novoProduto = new Produto(idAux, descricaoAux, precoAux, qtdEstoqueAux);
        produtos[totalDeProdutos] = novoProduto;

        System.out.print("\n");
        System.out.println("Produto inserido com sucesso.");
        System.out.printf("\tID.............: %d\n", idAux);
        System.out.printf("\tDescrição......: %s\n", descricaoAux);
        System.out.printf("\tPreço..........: %.2f\n", precoAux);
        System.out.printf("\tQtd. de Estoque: %d\n\n", qtdEstoqueAux);

        totalDeProdutos++;
    }

    public void alterarProduto() {
        if (totalDeProdutos == 0) {
            System.out.print("\n");
            System.out.println("Não há produtos cadastrados.");
            System.out.print("\n");
            return;
        }

        System.out.print("\n");
        System.out.println("=== Alteração de Produto ===");
        System.out.println("ID do Produto: ");
        int idAux = Teclado.scanInt();

        int indice = buscarProdutoPorIndice(idAux);
        if (indice == -1) {
            System.out.print("\n");
            System.out.println("Produto não encontrado.");
            System.out.print("\n");
            return;
        }

        System.out.printf("\nNova descrição (%s): ", produtos[indice].getDescricao());
        String novaDescricaoAux = Teclado.scanString();

        System.out.printf("\nNovo preço (%.2f): ", produtos[indice].getPreco());
        double novoPrecoAux = Teclado.scanDouble();
        Teclado.nextLine();

        System.out.printf("\nNova qtd. estoque (%d): ", produtos[indice].getQtdEstoque());
        int novoQtdEstoqueAux = Teclado.scanInt();
        Teclado.nextLine();

        produtos[indice].setDescricao(novaDescricaoAux);
        produtos[indice].setPreco(novoPrecoAux);
        produtos[indice].setQtdEstoque(novoQtdEstoqueAux);

        System.out.print("\n");
        System.out.println("Produto alterado com sucesso.");
        System.out.printf("\tID.............: %d\n", idAux);
        System.out.printf("\tDescrição......: %s\n", novaDescricaoAux);
        System.out.printf("\tPreço..........: %.2f\n", novoPrecoAux);
        System.out.printf("\tQtd. de Estoque: %d\n\n", novoQtdEstoqueAux);
    }

    public void excluirProduto() {
        if (totalDeProdutos == 0) {
            System.out.print("\n");
            System.out.println("Não há produtos cadastrados.");
            System.out.print("\n");
            return;
        }

        System.out.print("\n");
        System.out.println("=== Exclusão de Produto ===");
        System.out.println("ID do Produto: ");
        int idAux = Teclado.scanInt();

        int indice = buscarProdutoPorIndice(idAux);
        if (indice == -1) {
            System.out.print("\n");
            System.out.println("Produto não encontrado.");
            System.out.print("\n");
            return;
        }

        // armazena detalhes do produto deletado para a mensagem de confirmação
        String descricaoDeletada = produtos[indice].getDescricao();
        double precoDeletado = produtos[indice].getPreco();
        int qtdEstoqueDeletada = produtos[indice].getQtdEstoque();

        for (int i = indice; i < totalDeProdutos - 1; i++) {
            produtos[i] = produtos[i + 1];
        }

        System.out.print("\n");
        System.out.println("Produto excluído com sucesso.");
        System.out.printf("\tID.............: %d\n", idAux);
        System.out.printf("\tDescrição......: %s\n", descricaoDeletada);
        System.out.printf("\tPreço..........: %.2f\n", precoDeletado);
        System.out.printf("\tQtd. de Estoque: %d\n\n", qtdEstoqueDeletada);

        produtos[totalDeProdutos - 1] = null;
        totalDeProdutos--;
    }

    public void consultarTodosProdutos() {
        if (totalDeProdutos == 0) {
            System.out.print("\n");
            System.out.println("Não há produtos cadastrados.");
            System.out.print("\n");
            return;
        }

        System.out.println("=== Lista de Produtos ===");
        for (int i = 0; i < totalDeProdutos; i++) {
            Produto p = produtos[i];
            System.out.printf("\tID..........: %d\n", produtos[i].getId());
            System.out.printf("\tDescrição...: %s\n", p.getDescricao());
            System.out.printf("\tPreço.......: %.2f\n", p.getPreco());
            System.out.printf("\tQtd. Estoque: %d\n", p.getQtdEstoque());
            System.out.println("----------------------------");
        }
        System.out.print("\n");
    }

    private int buscarProdutoPorIndice(int id) {
        for (int i = 0; i < totalDeProdutos; i++) {
            if (produtos[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getValorTotalEstoque() {
        int tot = 0;

        for (int i = 0; i < totalDeProdutos; i++) {
            tot += produtos[i].getQtdEstoque();
        }
        return tot;
    }
}
