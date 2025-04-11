package exercicios.quatro.program2.domain;

public class Porta {
    private boolean aberta = false;
    private String cor;
    private double dimensaoX = 0.8;
    private double dimensaoY = 2.1;
    private double dimensaoZ = 0.05;

    public void abrePorta() {
        this.aberta = true;
    }

    public void fechaPorta() {
        this.aberta = false;
    }

    public boolean isPortaAberta() {
        return this.aberta;
    }

    public void definirCor(String nova_cor) {
        this.cor = nova_cor;
    }

    public void definirDimensao(double nova_dimensaoX, double nova_dimensaoY, double nova_dimensaoZ) {
        this.dimensaoX = nova_dimensaoX;
        this.dimensaoY = nova_dimensaoY;
        this.dimensaoZ = nova_dimensaoZ;
    }

    public void imprimirDados() {
        System.out.println("Cor       -> " + this.cor);
        System.out.println("Aberta?   -> " + ((this.isPortaAberta()) ? "Sim" : "Não"));
        System.out.printf("Dimensões -> %.2fm x %.2fm x %.2fm", this.dimensaoX, this.dimensaoY, this.dimensaoZ);
        System.out.print("\n\n");
    }
}
