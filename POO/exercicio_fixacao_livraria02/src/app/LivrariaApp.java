package app;

import domain.Livro;
import utils.Teclado;

public class LivrariaApp {
    private Livro[] catalogo; // ATRIBUTO ARRAY DE LIVROS PARA RECEBER OS OBJETOS LIVROS PARA SI
    private int totalLivros;
    private final static int CAPACIDADE_MAXIMA = 100;

    public LivrariaApp() { // PROCESSO DE INICIALIZAÇÃO DO ARRAY DE TAMANHO 100 E ZERADO (SEM LIVROS)
        catalogo = new Livro[CAPACIDADE_MAXIMA];
        totalLivros = 0;
    }


    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = Teclado.setInt("\nEscolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> realizarVenda();
                case 3 -> listarLivros();
                case 4 -> encerrarSistema();
                default -> System.out.println("\nOpção inválida.\n");
            }
        } while(opcao != 4);
    }


    private void exibirMenu() {
        System.out.println("\n=== LIVRARIA ===\n");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Realizar Venda");
        System.out.println("3. Listar Livros");
        System.out.println("4. Encerrar Sistema");
    }


    private void cadastrarLivro() {

    }

    private void realizarVenda() {

    }

    private void listarLivros() {

    }

    private void encerrarSistema() {
        System.out.println("\nEncerrando programa...");
    }


}
