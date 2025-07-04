package domain;

import exception.PrecoInvalidoException;
import util.Teclado;

public class LivrariaApp {
    private Livro[] catalogo;
    private int totalLivros;
    private static int CAPACIDADE_MAXIMA = 100; // atributos estáticos => CONSTANTES

    public LivrariaApp() {
        catalogo = new Livro[CAPACIDADE_MAXIMA];
        totalLivros = 0;
    }

    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = Teclado.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarLivros();
                case 2 -> venderLivro();
                case 3 -> listarLivros();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }


    private void exibirMenu() {
        System.out.println("\n=== SISTEMA GERENCIADOR DE LIVROS");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Realizar Venda");
        System.out.println("3. Listar Livros");
        System.out.println("0. Sair");
    }


    private void cadastrarLivros() {
        if (totalLivros >= CAPACIDADE_MAXIMA) {
            System.out.println("Catálogo cheio");
            return;
        }

        System.out.println("\n\n=== Tipos de Livro ===");
        System.out.println("1. Livro Físico");
        System.out.println("2. E-book");

        int tipo = Teclado.lerInteiro("Escolha o tipo: ");

        try {
//            String titulo = Teclado.lerString("Título: ");
//            String autor = Teclado.lerString("Autor: ");
//            double preco = Teclado.lerDouble("Preço: R$ ");

            if (tipo == 1) {
                String titulo = Teclado.lerString("Título: ");
                String autor = Teclado.lerString("Autor: ");
                double preco = Teclado.lerDouble("Preço: R$ ");

                double peso = Teclado.lerDouble("Peso (kg): ");
                int estoque = Teclado.lerInteiro("Estoque: ");

                catalogo[totalLivros] = new LivroFisico(titulo, autor, preco, peso, estoque);
                totalLivros++;
                System.out.println("**Livro Físico cadastrado com êxito**");
            } else if (tipo == 2) {
                String titulo = Teclado.lerString("Título: ");
                String autor = Teclado.lerString("Autor: ");
                double preco = Teclado.lerDouble("Preço: R$ ");

                double tamanho = Teclado.lerDouble("Tamanho do Arquivo (MB): ");
                String formato = Teclado.lerString("Formato (EPUB / PDF / etc): ");

                catalogo[totalLivros] = new Ebook(titulo, autor, preco, tamanho, formato);
                totalLivros++;
                System.out.println("**E-book cadastrado com êxito**");
            } else {
                System.out.println("Tipo Inválido");
            }
        } catch (PrecoInvalidoException e) {
            System.out.println("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    private void venderLivro() {
        if (totalLivros == 0) {
            System.out.println("Nenhum livro disponível para venda");
            return;
        }

        listarLivros();
        int index = Teclado.lerInteiro("Digite o número do Livro para vender: ");

        if (index < 0 || index >= totalLivros) {
            System.out.println("Identificador Inválido");
            return;
        }

        Livro livro = catalogo[index];
        Vendavel vendavel = (Vendavel) livro;

        if (vendavel.vender()) {
            System.out.println("**Venda realizada com êxito**");
            System.out.println("Livro Vendido: " + livro.getTitulo());

            double desconto = livro.getDesconto();
            if (desconto > 0) {
                double precoFinal = livro.getPreco() * (1 - desconto);
                System.out.printf("Preço com Desconto: R$ %.2f%n", precoFinal);
            }
        } else {
            System.out.println("**Venda não realizada** -- produto sem estoque");
        }
    }

    private void listarLivros() {
        if (totalLivros == 0) {
            System.out.println("Nenhum livro cadastrado ou encontrado");
            return;
        }

        System.out.println("\n\n=== Catálogo de Livros ===");
        for (int i = 0; i < totalLivros; i++) {
            System.out.printf("%d) %s%n", i, catalogo[i]);
        }
        System.out.println("Total de Livros: " + totalLivros);
    }
}


