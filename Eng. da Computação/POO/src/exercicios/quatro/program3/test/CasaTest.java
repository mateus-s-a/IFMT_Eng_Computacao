package exercicios.quatro.program3.test;

import exercicios.quatro.program3.domain.Casa;

public class CasaTest {
    public static void main(String[] args) {
        Casa casa = new Casa();
        casa.imprimirDados();

        System.out.println("--------------------");

        casa.pintarCasa("Vermelho");
        casa.imprimirDados();

        System.out.println("--------------------");

        System.out.println(casa.quantasPortasEstaoAbertas());
        casa.abrirPorta(1);
        casa.abrirPorta(2);
        casa.abrirPorta(3);
        System.out.println(casa.quantasPortasEstaoAbertas());
        casa.fecharPorta(2);
        System.out.println(casa.quantasPortasEstaoAbertas());

        System.out.println("--------------------");

        casa.imprimirDados();
    }
}
