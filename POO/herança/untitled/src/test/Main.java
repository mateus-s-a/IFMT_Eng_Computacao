package test;

import domain.Filho;
import domain.Pai;

public class Main {
    public static void main(String[] args) {
        Pai p = new Pai();
        p.setNome("NomePai");
        p.setIdade(50);

        Pai p2 = new Pai("NomePai2", 40);

        System.out.println(p.getNome());
        System.out.println(p.getIdade());

        System.out.println(p2.getNome());
        System.out.println(p2.getIdade());



        Filho f = new Filho();
        f.setNome("NomeFilho");
        f.setIdade(15);

        System.out.println(f.isReclamar());

        f.setReclamar(true);

        System.out.println(f.getNome());
        System.out.println(f.getIdade());
        System.out.println(f.isReclamar());
        f.gritar();

        Filho f2 = new Filho("Pedro", 18, true);

        System.out.println(f2.getNome());
        System.out.println(f2.getIdade());
        System.out.println(f2.isReclamar());
    }
}
