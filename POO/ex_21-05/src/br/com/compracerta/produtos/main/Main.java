package br.com.compracerta.produtos.main;

import br.com.compracerta.produtos.servicos.Menu;
import br.com.compracerta.produtos.servicos.ProdutoManager;

public class Main {
    public static void main(String[] args) {
        ProdutoManager produtoManager = new ProdutoManager(10);
        Menu menu = new Menu(produtoManager);

        menu.exibirMenu();
    }
}
