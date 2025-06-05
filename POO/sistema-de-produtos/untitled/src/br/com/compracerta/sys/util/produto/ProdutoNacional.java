package br.com.compracerta.sys.util.produto;

public class ProdutoNacional extends Produto {
    private double impostoNacional;

    public ProdutoNacional(int id, String descricao, double preco, int qtdEstoque, double impostoNacional) {
        super(id, descricao, preco, qtdEstoque);
        this.impostoNacional = impostoNacional;
    }

    public double getImpostoNacional() {
        return impostoNacional;
    }

    public void setImpostoNacional(double impostoNacional) {
        this.impostoNacional = impostoNacional;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() * (1 + impostoNacional / 100);
    }

    @Override
    public String toString() {
        return super.toString() + "\nImposto Nacional = " + impostoNacional + "%";
    }
}
