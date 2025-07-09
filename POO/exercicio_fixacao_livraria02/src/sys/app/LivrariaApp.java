package sys.app;

import sys.domain.Ebook;
import sys.domain.Livro;
import sys.domain.LivroFisico;
import sys.domain.Vendavel;
import sys.exception.PrecoInvalidoException;
import sys.utils.Teclado;

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

        // ANTES DO CÓDIGO DE IMPLEMENTAÇÃO DOS DADOS DO LIVRO SEREM ACURADOS
        // try...catch PRECISA SER CODIFICADO PARA A EXCEÇÃO DO PREÇO NEGATIVO
        // SE O PREÇO ESTIVER CERTO, NÃO HAVERÁ O ERRO CUSTOMIZADO PrecoInvalidoException
        // PARA AMBOS OS LIVROS FÍSICOS E E-BOOKS
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

        listarLivros();
        int index = Teclado.setInt("Escolha o Livro a Vender: ");

        if (index < 0 || index >= totalLivros) {
            System.out.println("Identificador Inválido");
            return;
        }

        Livro livro = catalogo[index]; // CRIA OBJETO LIVRO E COM O INDEX PARA ATRIBUIR UM EM ESPECÍFICO
        Vendavel vendavel = (Vendavel) livro; // CASTING PARA A INTERFACE Vendavel, POIS A CLASSE Livro não a implementa diretamente

        // CADA LIVRO POSSU UM MÉTÓDO vender() DA INTERFACE
        // DO LIVRO FÍSICO ELE VERIFICA SE AINDA HÁ ESTOQUE DESTE LIVRO INDEXADO index
        // SENÃO, ELE NÃO VENDE

        // POR QUE NÃO O CASO PARA E-BOOK?
        // E-BOOK RETORNA True PARA TODOS OS CASOS, POIS NÃO POSSUI IMPLEMENTAÇÃO
        // EM SEU MÉTÓDO vender()
        if (vendavel.vender()) { // SE A VENDA RETORNAR True (obedecer as exceções)
            System.out.println("\n**Venda realizada com êxito**\n");
            System.out.println("Livro Vendido: " + livro.getTitulo());

            double desconto = livro.getDesconto();
            if (desconto > 0) { // DIFERENÇA ENTRE UM DESCONTO PELO OS TIPOS DE LIVROS, SE FOR MAIOR, É O FÍSICO, SENÃO, E-BOOK
                double precoFinal = livro.getPreco() * (1 - desconto); // R$99 * (1 - 10%) = 99 * (1 - 0.1) = 99 * 0.9 = 89.1
                System.out.printf("Preço com Desconto: R$ %.2f", precoFinal);
            }
        } else {
            System.out.println("\n**Venda não realizada** -- produto sem estoque");
        }
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
        // IMPRIME O TOTAL DE LIVROS CADASTRADOS, NÃO SOMANDO POR UNIDADES
        // SOMENTE DAQUELES CADASTRADOS NO ARRAY DE CAPACIDADE_MAXIMA = 100
        System.out.println("\nTotal de Livros Cadastrados: " + totalLivros);
    }

    private void encerrarSistema() {
        System.out.println("\nEncerrando programa...");
    }


}
