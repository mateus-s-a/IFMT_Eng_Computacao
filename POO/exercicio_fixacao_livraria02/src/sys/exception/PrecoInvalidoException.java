package sys.exception;

public class PrecoInvalidoException extends Exception {
    // O ARQUIVO DE EXCEÇÃO CONTERÁ SOMENTE A PASSAGEM DA MENSAGEM DE ERRO, NÃO POSSUI NENHUMA CONDIÇÃO DE LÓGICA
    public PrecoInvalidoException(String message) {
        super(message);
    }
}
