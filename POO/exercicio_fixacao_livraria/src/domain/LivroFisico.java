package domain;

import exception.PrecoInvalidoException;

public class LivroFisico extends Livro implements Vendavel {
    private double peso;
    private int estoque;

    public LivroFisico(String titulo, String autor, double preco, double peso, int estoque)
            throws PrecoInvalidoException {
        super(titulo, autor, preco);
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

    public double calcularDesconto() {
        return (peso > 1.0) ? 0.10 : 0.05;
    }


    @Override
    public boolean vender() {
        if (estoque <= 0) {
            return false;
        }
        estoque--;
        return true;
    }

    @Override
    public double getDesconto() {
        return calcularDesconto();
    }

    @Override
    public String toString() {
        return " [ Físico | " +
                peso + " kg | " +
                estoque + " estoque | " +
                (calcularDesconto() * 100) + "% desconto ]";
    }
}
