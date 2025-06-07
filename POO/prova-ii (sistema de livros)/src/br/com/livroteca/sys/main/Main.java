package br.com.livroteca.sys.main;

import br.com.livroteca.sys.menu.Menu;
import br.com.livroteca.sys.modelo.Livro;

public class Main {
    public static void main(String[] args) {
        Livro[] livros = new Livro[10];
        Menu.exibirMenu(livros);
    }
}
