package br.com.compracerta.sys.util.menu;

import br.com.compracerta.sys.util.Teclado;
import br.com.compracerta.sys.util.produto.Produto;
import br.com.compracerta.sys.util.produto.ProdutoInternacional;
import br.com.compracerta.sys.util.produto.ProdutoNacional;

public class Menu {
    public static void exibirMenu(Produto[] produtos) {
        int opcao;

        do {
            System.out.println("\n --- SITEMA DE PRODUTOS ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Excluir");
            System.out.println("3 - Alterar");
            System.out.println("4 - Consultar");
            System.out.println("0 - Encerrar");

            opcao = Teclado.lerInteiro("Escolha uma opção:");

            switch (opcao) {
                // cadastro
                case 1: {
                    System.out.println("\n --- NACIONAL | INTERNACIONAL ---");
                    int tipoProduto = Teclado.lerInteiro("Escolha o tipo: ");

                    Produto novoProduto; // produto generico, posteriormente será tipado

                    int id = Teclado.lerInteiro("ID do Produto: ");
                    String descricao = Teclado.lerString("Descrição: ");
                    double preco = Teclado.lerDouble("Preço: ");
                    int quantidade = Teclado.lerInteiro("Quantidade: ");

                    if (tipoProduto == 1) { // Nacional
                        // atributo especial somente de Produto Nacional
                        double impostoNacional = Teclado.lerDouble("Imposto Nacional do produto: ");
                        novoProduto = new ProdutoNacional(id, descricao, preco, quantidade, impostoNacional);
                    } else {
                        // atributo especial somente de Produto Internacional
                        double taxaImportacao = Teclado.lerDouble("Taxa de Importação: ");
                        novoProduto = new ProdutoInternacional(id, descricao, preco, quantidade, taxaImportacao);
                    }

                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] == null) {
                            produtos[i] = novoProduto;
                            System.out.println("Produto cadastrado com sucesso");
                            break;
                        }
                    }
                    break;
                }

                // excluir
                case 2: {
                    System.out.println("\n --- EXCLUSÃO ---");
                    int id = Teclado.lerInteiro("ID para Excluir produto: ");

                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null && produtos[i].getId() == id) {
                            produtos[i] = null;
                            System.out.println("Produto excluído.");
                            break;
                        }
                    }
                    break;
                }

                // alterar
                case 3: {
                    System.out.println("\n --- ALTERAR ---");
                    int id = Teclado.lerInteiro("ID para alterar produto: ");

                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null && produtos[i].getId() == id) {
                            produtos[i].setDescricao(Teclado.lerString("Nova descrição: "));
                            produtos[i].setPreco(Teclado.lerDouble("Novo preço: "));
                            produtos[i].setQtdEstoque(Teclado.lerInteiro("Nova qtd.: "));

                            System.out.println("Produto alterado.");
                            break;
                        }
                    }
                    break;
                }

                // consultar
                case 4: {
                    System.out.println("\n --- ALTERAR ---");

                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null) {
                            System.out.println(produtos[i]);
                        }
                    }
                    System.out.printf("\nValor total do estoque: R$ %.2f", Produto.calcularEstoque(produtos));
                    break;
                }

                // encerrar
                case 0: {
                    System.out.println("\nEncerrando programa...");
                    break;
                }

                default: {
                    System.out.println("\nOpção Inválida.\n");
                    break;
                }

            }
        } while (opcao != 0);
    }
}
