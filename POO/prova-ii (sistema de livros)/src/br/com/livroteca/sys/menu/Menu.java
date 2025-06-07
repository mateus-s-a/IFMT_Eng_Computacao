package br.com.livroteca.sys.menu;

import br.com.livroteca.sys.modelo.Livro;
import br.com.livroteca.sys.modelo.LivroDigital;
import br.com.livroteca.sys.modelo.LivroFisico;
import br.com.livroteca.sys.util.Teclado;

public class Menu {
    public static void exibirMenu(Livro[] livros) {
        int opcao;

        do {
            System.out.println("\n === BIBLIOTECA LIVROS FISICOS/DIGITAIS ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Alterar");
            System.out.println("4 - Consultar");
            System.out.println("0 - Encerrar");

            opcao = Teclado.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1: {
                    System.out.println("\n === TIPO DO LIVRO ===");
                    System.out.println("1 - Físico");
                    System.out.println("2 - Digital");
                    int tipoLivro = Teclado.lerInteiro("Escolha um tipo: ");

                    int id = Teclado.lerInteiro("ID: ");
                    String titulo = Teclado.lerString("Título: ");
                    double precoBase = Teclado.lerDouble("Preço Base: ");
                    int qtdEstoque = Teclado.lerInteiro("Qtd. no Estoque: ");

                    Livro novoLivro = null;

                    if (tipoLivro == 1) {
                        double custoImpresso = Teclado.lerDouble("(Físico) Custo da Impressão: ");
                        novoLivro = new LivroFisico(id, titulo, precoBase, qtdEstoque, custoImpresso);
                    } else if (tipoLivro == 2) {
                        double percentualDesconto = Teclado.lerDouble("(Digital) Percentual de Desconto: ");
                        novoLivro = new LivroDigital(id, titulo, precoBase, qtdEstoque, percentualDesconto);
                    } else {
                        System.out.println("\nTipo de livro inexistente.");
                    }

                    for (int i = 0; i < livros.length; i++) {
                        if (livros[i] == null) {
                            livros[i] = novoLivro;
                            System.out.println("\nLivro cadastrado.\n");
                            break;
                        }
                    }

                    break;
                }

                case 2: {
                    System.out.println("\n === EXCLUIR LIVRO ===");
                    int id = Teclado.lerInteiro("ID: ");

                    for (int i = 0; i < livros.length; i++) {
                        if (livros[i] != null && livros[i].getId() == id) {
                            livros[i] = null;
                            System.out.println("\nLivro escluído.\n");
                            break;
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.println("\n === ALTERAR LIVRO ===");
                    int id = Teclado.lerInteiro("ID: ");

                    for (int i = 0; i < livros.length; i++) {
                        if (livros[i] != null && livros[i].getId() == id) {
                            livros[i].setTitulo(Teclado.lerString("Novo Título: "));
                            livros[i].setPrecoBase(Teclado.lerDouble("Novo Preço Base: "));
                            livros[i].setQtdEstoque(Teclado.lerInteiro("Novo Qtd. Estoque: "));
                            break;
                        }
                    }
                    break;
                }

                case 4: {
                    System.out.println("\n === CONSULTAR LIVROS ===");

                    for (int i = 0; i < livros.length; i++) {
                        if (livros[i] != null) {
                            System.out.println(livros[i].toString());
                        }
                    }

                    System.out.printf("Valor Total do Estoque: R$ %.2f", Livro.calcularValorTotalEstoque(livros));
                    break;
                }

                case 0: {
                    System.out.println("\nEncerrando programa...");
                    break;
                }

                default: {
                    System.out.println("\nOpção Inválida.");
                    break;
                }
            }
        } while (opcao != 0);
    }
}
