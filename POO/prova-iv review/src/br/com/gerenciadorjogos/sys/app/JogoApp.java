package br.com.gerenciadorjogos.sys.app;

import br.com.gerenciadorjogos.sys.domain.Jogo;
import br.com.gerenciadorjogos.sys.domain.JogoDigital;
import br.com.gerenciadorjogos.sys.domain.JogoFisico;
import br.com.gerenciadorjogos.sys.exceptions.PrecoInvalidoException;
import br.com.gerenciadorjogos.sys.utils.Teclado;

public class JogoApp {
    private Jogo[] catalogo = new Jogo[5]; // catálogo de 5 espaços para armazenar

    public void cadastrarJogo() {
        System.out.println("\n\t === CADASTRAR JOGO ===\n");
        System.out.println("1. Jogo Físico");
        System.out.println("2. Jogo Digital");
        int tipo = Teclado.lerInt("Escolha o tipo do jogo: ");

        if (tipo < 1 || tipo > 2) {
            System.out.println("\n\t> Erro: tipo de jogo inválido");
            return;
        }

        int id = Teclado.lerInt("\nID: ");
        String titulo = Teclado.lerString("Título: ");
        String plataforma = Teclado.lerString("Plataforma: ");
        double preco = Teclado.lerDouble("Preço (R$): ");
        try {
            if (tipo == 1) {
                double peso = Teclado.lerDouble("Peso (g): ");
                int estoque = Teclado.lerInt("Estoque: ");

                JogoFisico novoJogo = new JogoFisico(id, titulo, plataforma, preco, peso, estoque);
                double precoComDesconto = preco - novoJogo.calcularDesconto();
                novoJogo.setPreco(precoComDesconto);

                for (int i = 0; i < catalogo.length; i++) {
                    if (catalogo[i] == null) {
                        catalogo[i] = novoJogo;
                        System.out.println("\n\t**Jogo Físico cadastrado com êxito.**\n");
                        return;
                    }
                }
                System.out.println("\n\t> Erro: limite de jogos atingido\n"); // caso o loop não encontre um espaço vazio na lista (null), está cheio
            }

            else { // somente possibilidade de ser tipo 2
                double tamanhoArquivo = Teclado.lerDouble("Tamanho do Arquivo (MB): ");
                String tipoLicenca = Teclado.lerString("Tipo de Lincença: ");

                JogoDigital novoJogo = new JogoDigital(id, titulo, plataforma, preco, tamanhoArquivo, tipoLicenca);

                for (int i = 0; i < catalogo.length; i++) {
                    if (catalogo[i] == null) {
                        catalogo[i] = novoJogo;
                        System.out.println("\n\t**Jogo Digital cadastrado com êxito.**\n");
                        return;
                    }
                }
                System.out.println("\n\t> Erro: limite de jogos atingido\n");
            }
        } catch (PrecoInvalidoException e) {
            System.out.println("\n\t> Ocorreu um erro: " + e.getMessage());
        }
    }

    public void realizarVenda() {
        listarJogos();
        int index = Teclado.lerInt("\nSelecione o ID do Jogo a ser vendido: ");
        int quantidade = Teclado.lerInt("Digite a quantidade que será vendida: ");

        if (index > catalogo.length) {
            System.out.println("\n\t> Erro: ID não condizente\n");
            return;
        }

        for (int i = 0; i < catalogo.length; i++) {
            if (catalogo[i] != null && catalogo[i].getId() == index) {
                if (catalogo[i].vender(quantidade)) {
                    System.out.println("\n**Jogo VENDIDO com êxito.**");
                } else {
                    System.out.println("\t\n> Erro venda não concluída: sem quantidade no estoque"); // caso específico para JogosFisicos
                }
                return;
            }
        }
    }

    public void listarJogos() {
        System.out.println("\n\t=== LISTAGEM DOS JOGOS ===\n");

        for (int i = 0; i < catalogo.length; i++) {
            if (catalogo[i] != null) {
                System.out.println((i+1) + ") " + catalogo[i]);
            }
        }
    }
}
