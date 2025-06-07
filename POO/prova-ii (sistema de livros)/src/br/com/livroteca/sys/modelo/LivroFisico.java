package br.com.livroteca.sys.modelo;

public class LivroFisico extends Livro {
    private double custoImpressao; // VALOR FIXO

    public LivroFisico(int id, String titulo, double precoBase, int qtdEstoque, double custoImpressao) {
        super(id, titulo, precoBase, qtdEstoque);
        this.custoImpressao = custoImpressao;
    }

    public double getCustoImpressao() {
        return custoImpressao;
    }

    public void setCustoImpressao(double custoImpressao) {
        this.custoImpressao = custoImpressao;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() + custoImpressao;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCusto de Impressão: R$ " + custoImpressao +
                "\nPreço Final: R$ " + calcularPrecoFinal() +
                "\nTipo: Fisico\n";
    }
}
