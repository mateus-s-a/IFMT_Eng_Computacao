package sys.domain;

import sys.exception.PrecoInvalidoException;

public class Ebook extends Livro implements Vendavel {
    private double tamanhoArquivo;
    private String formatoArquivo;

    public Ebook(String titulo, String autor, double preco, double tamanhoArquivo, String formatoArquivo)
            throws PrecoInvalidoException {
        super(titulo, autor, preco);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formatoArquivo = formatoArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }
    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }



    @Override
    public boolean vender() {
        // E-BOOKS NÃO POSSUEM RESTRIÇÃO DE ESTOQUE
        return true;
    }

    // ... [ E-BOOK | (tamanhoArquivo) MB | (formatoArquivo) ]
    @Override
    public String toString() {
        return super.toString() + " [ E-BOOK | " + tamanhoArquivo +
                " MB | " + formatoArquivo + " ]";
    }


}
