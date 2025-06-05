package domain;

public class Filho extends Pai {
    private boolean reclamar;

    public Filho() {
        super(); // Classe Filho agora herda os atributos da classe Pai
        reclamar = false;
    }

    public Filho(String nome, int idade, boolean reclamar) {
        super(nome, idade);
        this.reclamar = reclamar;
    }

    public boolean isReclamar() {
        return reclamar;
    }

    public void setReclamar(boolean reclamar) {
        this.reclamar = reclamar;
    }

    @Override // @Override (Sobrescrever) é dar um novo comportamento ao método
    public void gritar() {
        System.out.println("HAHAHAHAHAHAHA");
    }
}
