package domain;

import exception.PrecoInvalidoException;

public class Ebook extends Livro implements Vendavel {
    private double tamanhoArquivo;
    private String formatoArquivo;



    @Override
    public boolean vender() {
        // E-BOOKS NÃO POSSUEM RESTRIÇÃO DE ESTOQUE
        return true;
    }
}
