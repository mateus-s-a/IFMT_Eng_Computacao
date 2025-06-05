package domain;

public class Pai {
    private String nome;
    private int idade;

    public Pai() {
        nome = "";
        idade = 0;
    }

    public Pai(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void gritar() {
        System.out.println("AAAAAAAAAAAAAA");
    }
}
