package test;

import domain.FuncionarioManager;
import domain.Menu;

public class Main {
    public static void main(String[] args) {
        FuncionarioManager funcionarioManager = new FuncionarioManager(10);
        Menu menu = new Menu(funcionarioManager);

        menu.exibirMenu();
    }
}
