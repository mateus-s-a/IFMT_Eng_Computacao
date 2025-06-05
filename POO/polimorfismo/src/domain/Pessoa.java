package domain;

public class Pessoa {
    // Polimorfismo: @Override, Sobrecarga

    public void falar() {
        System.out.println("Oi");
    }

    public void falar(String texto) {
        System.out.println(texto);
    }

    public void falar(String texto, int quantidade) {
        System.out.println("Qtd " + quantidade + " " + texto);
    }

    public void falar(int quantidade) {
        System.out.println(quantidade);
    }
}
