package exercicios.quatro.test;

import exercicios.quatro.domain.Conta;
import exercicios.quatro.domain.Data;

public class ContaTest {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        Data data = new Data();
        c1.titular = "Danilo";
        c1.saldo = 100.0;
        c1.dataDeAbertura = data;

        Conta c2 = new Conta();
        c2.titular = "Danilo";
        c2.saldo = 100.0;

        System.out.println((c1 == c2) ? "iguais" : "diferentes");



        c1.titular = "Hugo";
        c2 = c1;

        System.out.println((c1 == c2) ? "iguais" : "diferentes");

        System.out.println(c1.recuperaDadosParaImpressao());
    }
}
