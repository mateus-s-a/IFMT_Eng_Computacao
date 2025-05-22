package br.com.compracerta.produtos.modelo;

public class Produto {
    private int id = 1;
    private String descricao;
    private double preco;
    private int qtd_estoque;

    public Produto(int id, String descricao, double preco, int qtd_estoque) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd_estoque = qtd_estoque;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtdEstoque() {
        return qtd_estoque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQtdEstoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }
}
