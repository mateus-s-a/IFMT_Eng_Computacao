package exercicios.quatro.domain;

public class Data {
    public int dia;
    public int mes;
    public int ano;

    public String dataFormatada() {
        String msg = this.dia + "/";
        msg += this.mes + "/";
        msg += this.ano;

        return msg;
    }
}
