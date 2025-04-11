package test;

import domain.Funcionario;
import domain.Menu;

public class Main {
    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[10];
        Menu menu = new Menu();

        menu.exibirMenu();

        System.out.println(funcionarios[0].nome);
        System.out.println(funcionarios[1].nome);
    }
}
