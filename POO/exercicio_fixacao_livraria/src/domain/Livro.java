package domain;

import exception.PrecoInvalidoException;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco)
            throws PrecoInvalidoException {
        this.titulo = titulo;
        this.autor = autor;
        setPreco(preco);
    }

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public double getPreco() {
        return preco;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setPreco(double preco) throws PrecoInvalidoException {
        if (preco < 0) {
            throw new PrecoInvalidoException(
                    "Preço não pode ser negativo: " + preco
            );
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return titulo + "(" + autor + "): R$ " + preco;
    }
}
