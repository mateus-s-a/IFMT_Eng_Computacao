package sys.domain;

import sys.exception.PrecoInvalidoException;

public abstract class Livro {
    private String titulo;
    private String autor;
    private double preco;


    // TODOS OS ARQUIVOS EXTENDIDOS DE Livro.java DEVERÃO TER O KEYWORK `throws` EXCEPTION
    public Livro(String titulo, String autor, double preco)
            throws PrecoInvalidoException {
        this.titulo = titulo;
        this.autor = autor;
        // O SETPRECO() POSSUI UMA EXCEÇÃO QUE PRECISA SER VERIFICADA ANTES DE SER ATRIBUÍDA POR COMPLETO NO CONSTRUTOR
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
    public void setPreco(double preco) // POSSUI UMA EXCEÇÃO PARA O PREÇO NÃO SER NEGATIVO
            throws PrecoInvalidoException {
        if (preco < 0) {
            throw new PrecoInvalidoException(
                    "Preço não pode ser negativo." + preco
            );
        }
        this.preco = preco;
    }

    public double getDesconto() {
        return 0.0; // VALOR PADRÃO (para os E-BOOKS NÃO MUDARÁ NADA, POIS NÃO POSSUEM PESO)
    }


    @Override
    public String toString() {
        return titulo + "(" + autor + "): R$ " + preco;
    }
}
