package exercicios.quatro.program1.test;

import exercicios.quatro.program1.domain.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();

        p1.setNome("Matthew");
        p1.setIdade(20);

        p1.imprimirDados();

        p1.fazAniversario();
        p1.fazAniversario();
        p1.fazAniversario();
        p1.fazAniversario();
        p1.fazAniversario();

        p1.imprimirDados();
    }
}
