package exercicios.quatro.program2.test;

import exercicios.quatro.program2.domain.Porta;

public class PortaTest {
    public static void main(String[] args) {
        Porta porta = new Porta();

        porta.definirCor("Marrom");
        porta.imprimirDados();

        porta.abrePorta();
        porta.definirDimensao(0.85, 2.0, 0.04);
        porta.imprimirDados();

        porta.fechaPorta();
        porta.imprimirDados();

        System.out.println(porta.isPortaAberta());
    }
}
