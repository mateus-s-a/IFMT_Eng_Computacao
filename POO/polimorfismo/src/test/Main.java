package test;

import domain.Funcionario;
import domain.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        Funcionario f = new Funcionario();

        p.falar();
        f.falar();
    }
}
