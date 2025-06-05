package br.com.compracerta.sys.util.produto;

public class Produto {
    private int id;
    private String descricao;
    private double preco;
    private int qtdEstoque;

    public Produto(int id, String descricao, double preco, int qtdEstoque) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double calcularPrecoFinal() {
        return this.preco;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nDescrição: " + descricao +
                "\nPreço: " + preco +
                "\nQuantidade: " + qtdEstoque +
                "\nPreço Final: " + calcularPrecoFinal();
    }

    public static double calcularEstoque(Produto[] produtos) {
        double total = 0.0;

        for (Produto p : produtos) {
            if (p != null) {
                total += p.calcularPrecoFinal() * p.getQtdEstoque();
            }
        }
        return total;
    }
}
