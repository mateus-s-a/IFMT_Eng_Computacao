package br.com.livroteca.sys.modelo;

public class LivroDigital extends Livro {
    private double percentualDesconto; // VALOR PERCENTUAL

    public LivroDigital(int id, String titulo, double precoBase, int qtdEstoque, double percentualDesconto) {
        super(id, titulo, precoBase, qtdEstoque);
        this.percentualDesconto = percentualDesconto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() * (1 - percentualDesconto / 100);
    }

    @Override
    public String toString() {
        return super.toString() + "\nPercentual de Desconto: " + percentualDesconto + "%" +
                "\nPreço Final: R$ " + calcularPrecoFinal() +
                "\nTipo: Digital\n";
    }
}
