package br.com.website.sys.app;

import br.com.website.sys.domain.Jogo;
import br.com.website.sys.domain.JogoFisico;
import br.com.website.sys.exceptions.PrecoInvalidoException;
import br.com.website.sys.utils.Teclado;

public class JogoApp {
    private Jogo[] catalogo = new Jogo[5];


    public void cadastrarJogo() {
        System.out.println("\n\t === CADASTRAR JOGO ===\n");
        System.out.println("1. Jogo Físico");
        System.out.println("2. Jogo Digital");
        int tipo = Teclado.lerInt("Escolha o tipo do Jogo: ");

        if (tipo < 1 || tipo > 2) {
            System.out.println("\n\t> Erro: tipo de jogo inválido");
            return;
        }

        int id = Teclado.lerInt("\nID: ");
        String titulo = Teclado.lerString("Título: ");
        String plataforma = Teclado.lerString("Plataforma: ");
        double preco = Teclado.lerDouble("Preço: ");
        try {
            if (tipo == 1) {
                double peso = Teclado.lerDouble("Peso (g): ");
                int estoque = Teclado.lerInt("Estoque: ");

                JogoFisico novoJogo = new JogoFisico(id, titulo, plataforma, preco, peso, estoque); // se preço for negativo, gerará um erro
                double precoComDesconto = preco - novoJogo.calcularDesconto();
                novoJogo.setPreco(precoComDesconto);

                for (int i = 0; i < catalogo.length; i++) {
                    if (catalogo[i] == null) {
                        catalogo[i] = novoJogo;
                        System.out.println("\n\t**Jogo Físico cadastrado com sucesso.**\n");
                        return;
                    }
                }
                System.out.println("\n\t> Erro: limite de jogos atingido\n"); // quando não mais espaço na lista de catálogo
            } else {

            }
        } catch (PrecoInvalidoException e) {
            System.out.println("\n\t> Ocorreu um erro: " + e.getMessage());
        }
    }

    public void realizarVenda() {

    }

    public void listarJogos() {

    }
}
