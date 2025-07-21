package br.com.website.sys.domain;

import br.com.website.sys.exceptions.PrecoInvalidoException;

public abstract class Jogo implements Vendavel {
    private int id;
    private String titulo;
    private String plataforma;
    private double preco;


    public Jogo(int id, String titulo, String plataforma, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        setPreco(preco);
    }


    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getPlataforma() {
        return plataforma;
    }
    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new PrecoInvalidoException("preço não pode ser negativo ou nulo");
        }
        this.preco = preco;
    }


    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", preco=" + preco +
                '}';
    }
}
