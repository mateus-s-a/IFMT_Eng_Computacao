package br.com.website.sys.domain;

public class JogoFisico extends Jogo {
    private double peso;
    private int estoque;


    public JogoFisico(int id, String titulo, String plataforma, double preco, double peso, int estoque) {
        super(id, titulo, plataforma, preco);
        this.peso = peso;
        this.estoque = estoque;
    }


    public double getPeso() {
        return peso;
    }
    public int getEstoque() {
        return estoque;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    private double calcularDesconto() {
        return (peso / 100) * 0.025 * getPreco();
    }


    @Override
    public boolean vender(int quantidade) {
        if (estoque > quantidade) {
            return false;
        }
        this.estoque = estoque - quantidade;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
