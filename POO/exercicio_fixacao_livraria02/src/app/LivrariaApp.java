package app;

import domain.Ebook;
import domain.Livro;
import domain.LivroFisico;
import exception.PrecoInvalidoException;
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
        if (totalLivros >= CAPACIDADE_MAXIMA) {
            System.out.println("\nCatálogo de Livros cheio.\n");
            return;
        }

        System.out.println("\n=== CADASTRAR LIVRO ===\n");
        System.out.println("1. Livro Físico");
        System.out.println("2. E-Book");
        int tipo = Teclado.setInt("Selecione o Tipo do Livro");

        try {
            if (tipo == 1) {
                String titulo = Teclado.setString("Título: ");
                String autor = Teclado.setString("Autor: ");
                double preco = Teclado.setDouble("Preço (R$): ");

                double peso = Teclado.setDouble("Peso (Kg): ");
                int estoque = Teclado.setInt("Estoque: ");

                catalogo[totalLivros] = new LivroFisico(titulo, autor, preco, peso, estoque);
                totalLivros++;
                System.out.println("\n**Livro Físico cadastrado com êxito**");
            } else if (tipo == 2) {
                String titulo = Teclado.setString("Título...: ");
                String autor = Teclado.setString("Autor.....: ");
                double preco = Teclado.setDouble("Preço (R$): ");

                double tamanhoArquivo = Teclado.setDouble("Tamanho do Arquivo (MB): ");
                String formatoArquivo = Teclado.setString("Formato do Arquivo (.pdf, .epub, .mobi): ");

                catalogo[totalLivros] = new Ebook(titulo, autor, preco, tamanhoArquivo, formatoArquivo);
                totalLivros++;
                System.out.println("\n**E-Book cadastrado com êxito**");
            } else {
                System.out.println("\nTipo de Livro Inválido, tente novamente.\n");
            }
        } catch (PrecoInvalidoException e) {
            System.out.println("\nErro ao Cadastrar Livro: " + e.getMessage());
        }
    }

    private void realizarVenda() {
        if (totalLivros == 0) {
            System.out.println("\nNenhum livro encontrado para venda.\n");
            return;
        }

        System.out.println("\n=== REALIZAR VENDA ===\n");
    }

    private void listarLivros() {
        if (totalLivros == 0) {
            System.out.println("\nNenhum livro encontrado para listar.\n");
            return;
        }

        System.out.println("\n=== LISTANDO LIVROS ===\n");
        for (int i = 0; i < totalLivros; i++) {
            System.out.println(i + ") " + catalogo[i]);
        }
        System.out.println("\nTotal de Livros: " + totalLivros);
    }

    private void encerrarSistema() {
        System.out.println("\nEncerrando programa...");
    }


}
