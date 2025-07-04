package domain;

import exception.PrecoInvalidoException;

public class Ebook extends Livro implements Vendavel {
    private double tamanhoArquivo;
    private String formato;

    public Ebook(String titulo, String autor, double preco, double tamanhoArquivo, String formato)
            throws PrecoInvalidoException {
        super(titulo, autor, preco);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formato = formato;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }
    public String getFormato() {
        return formato;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }


    @Override
    public boolean vender() {
        // ebooks não possuem restrição de estoque
        return true;
    }

    @Override
    public String toString() {
        return "[ E-book | " + tamanhoArquivo +
                " MB | " + formato + " ]";
    }
}
