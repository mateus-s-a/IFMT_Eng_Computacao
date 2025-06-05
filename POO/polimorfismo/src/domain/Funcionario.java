package domain;

public class Funcionario extends Pessoa {
    @Override
    public void falar() {
        System.out.println("Olá funcionário.");
    }
}
