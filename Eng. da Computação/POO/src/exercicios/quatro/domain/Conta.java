package exercicios.quatro.domain;

public class Conta {
    public String titular;
    public int numero;
    public String agencia;
    public double saldo;
    public Data dataDeAbertura;


    public void sacarValor(double retirado) {
        this.saldo -= retirado;
    }

    public void depositarValor(double depositado) {
        this.saldo += depositado;
    }

    public double calculaRendimento() {
        return saldo * 0.1;
    }

    public String recuperaDadosParaImpressao() {
        String mensagem = "\nTitular: " + this.titular;
        mensagem += "\nNúmero: " + this.numero;
        mensagem += "\nAgência: " + this.agencia;
        mensagem += "\nSaldo: " + this.saldo;
        mensagem += "\nData de Abertura: " + this.dataDeAbertura.dataFormatada();

        return mensagem;
    }
}
