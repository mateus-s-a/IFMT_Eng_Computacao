package br.com.compracerta.sys.util.main;

import br.com.compracerta.sys.util.menu.Menu;
import br.com.compracerta.sys.util.produto.Produto;

public class Main {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[10];
        Menu.exibirMenu(produtos);
    }
}
