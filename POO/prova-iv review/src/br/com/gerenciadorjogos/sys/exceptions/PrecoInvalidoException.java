package br.com.gerenciadorjogos.sys.exceptions;

public class PrecoInvalidoException extends RuntimeException {
    public PrecoInvalidoException(String message) {
        super(message);
    }
}
