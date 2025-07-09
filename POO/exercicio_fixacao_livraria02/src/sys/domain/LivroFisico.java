package sys.domain;

import sys.exception.PrecoInvalidoException;

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

    // ESTE MÉTÓDO É SOMENTE PARA OS LIVROS FÍSICOS
    public double calcularDesconto() {
        // SE LIVRO FOR MAIOR QUE 1Kg, 10% SENÃO 5% DE DESCONTO NO MESMO
        return (peso > 1.0) ? 0.10 : 0.05;
    }



    @Override
    public double getDesconto() {
        return calcularDesconto();
    }

    @Override
    public boolean vender() {
        if (estoque <= 0) {
            return false;
        }
        estoque--;
        return true;
    }

    // ... [ FÍSICO | (peso) Kg | (estoque) | (porcentagem de desconto)% de Desconto ]
    @Override
    public String toString() {
        return super.toString() + " [ FÍSICO | " +
                peso + "Kg | " +
                estoque + " Unidades | " +
                (calcularDesconto() * 100) + "% de Desconto ]";
    }
}
