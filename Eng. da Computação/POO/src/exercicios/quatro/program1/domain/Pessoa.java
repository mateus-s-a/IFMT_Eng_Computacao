package exercicios.quatro.program1.domain;

public class Pessoa {
    private String nome;
    private int idade;

    public void fazAniversario() {
        this.idade++;
    }

    public void imprimirDados() {
        System.out.println("Nome  -> " + this.nome);
        System.out.println("Idade -> " + this.idade);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
