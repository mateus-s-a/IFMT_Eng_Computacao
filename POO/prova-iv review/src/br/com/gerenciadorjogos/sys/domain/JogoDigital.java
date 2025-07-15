package br.com.gerenciadorjogos.sys.domain;

public class JogoDigital extends Jogo {
    private double tamanhoDownload;
    private String tipoLicenca;


    public JogoDigital(int id, String titulo, String plataforma, double preco, double tamanhoDownload, String tipoLicenca) {
        super(id, titulo, plataforma, preco);
        this.tamanhoDownload = tamanhoDownload;
        this.tipoLicenca = tipoLicenca;
    }

    public double getTamanhoDownload() {
        return tamanhoDownload;
    }
    public String getTipoLicenca() {
        return tipoLicenca;
    }

    public void setTamanhoDownload(double tamanhoDownload) {
        this.tamanhoDownload = tamanhoDownload;
    }
    public void setTipoLicenca(String tipoLicenca) {
        this.tipoLicenca = tipoLicenca;
    }


    @Override
    public boolean vender(int quantidade) {
        return true; // jogos digitais não possuem "estoque"
    }

    @Override
    public String toString() {
        return super.toString() + " | DIGITAL | " +
                getTamanhoDownload() + "GB | " +
                getTipoLicenca() + " ]";
    }
}
