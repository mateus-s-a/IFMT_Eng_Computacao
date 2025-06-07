package br.com.livroteca.sys.modelo;

public class Livro {
    private int id;
    private String titulo;
    private double precoBase;
    private int qtdEstoque;

    public Livro(int id, String titulo, double precoBase, int qtdEstoque) {
        this.id = id;
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double calcularPrecoFinal() {
        return precoBase;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nTítulo: " + titulo +
                "\nPreço Base: R$ " + precoBase +
                "\nQtd. Estoque: R$ " + qtdEstoque;
    }

    public static double calcularValorTotalEstoque(Livro[] livros) {
        double soma = 0.0;

        for (Livro livro : livros) {
            if (livro != null) {
                soma += livro.getPrecoBase() * livro.getQtdEstoque();
            }
        }

        return soma;
    }
}
