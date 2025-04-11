package exercicios.quatro.program3.domain;

public class Casa {
    private String cor;
    private boolean[] portas = new boolean[3];

    public int quantasPortasEstaoAbertas() {
        int count = 0;
        for (boolean i : this.portas) {
            if (i) {
                count++;
            } else {
                continue;
            }
        }

        return count;
    }

    public void pintarCasa(String cor) {
        this.cor = cor;
    }

    public void abrirPorta(int numero_da_porta) {
        portas[numero_da_porta - 1] = true;
    }
    public void fecharPorta(int numero_da_porta) {
        portas[numero_da_porta - 1] = false;
    }

    public void imprimirDados() {
        System.out.println("Cor da Casa --> " + this.cor);
        for (int i = 0; i < this.portas.length; i++) {
            System.out.printf("Porta %d     --> %s", i + 1, (this.portas[i]) ? "Aberta\n" : "Fechada\n");
        }
    }
}
