package sys.test;

import sys.app.LivrariaApp;

// src.br.com.livroteca.sys...
/*
O padrão da Sun para dar nome aos pacotes é relativo ao nome da empresa que desenvolveu a
classe:
br.com.nomedaempresa.nomedoprojeto.subpacote
br.com.nomedaempresa.nomedoprojeto.subpacote2
br.com.nomedaempresa.nomedoprojeto.subpacote2.subpacote3
 */

public class Main {
    public static void main(String[] args) {
        LivrariaApp livrariaApps = new LivrariaApp();
        livrariaApps.executar();
    }
}
