package domain;

import exception.PrecoInvalidoException;

public abstract class Livro {
    private String titulo;
    private String autor;
    private double preco;


    // TODOS OS ARQUIVOS EXTENDIDOS DE Livro.java DEVERÃO TER O KEYWORK `throws` EXCEPTION
    public Livro(String titulo, String autor, double preco)
            throws PrecoInvalidoException {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
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
    public void setPreco(double preco)
            throws PrecoInvalidoException {
        if (preco < 0) {
            throw new PrecoInvalidoException(
                "\nPreço não pode ser negativo: " + preco
            );
        }
    }
}
