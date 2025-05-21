package br.com.compracerta.produtoatualizado.domain;

public class Produto {
    private int id;
    private String descricao;
    private float preco;
    private int qtd_estoque;

    public Produto(int id, String descricao, float preco, int qtd_estoque) {
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

    public float getPreco() {
        return preco;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }
}
