package sys.domain;

public interface Vendavel {
    // O CONTRATO DE Vendavel SE EXPANDE PARA TODOS OS LIVROS TEREM UMA FORMA DE VENDA
    // QUE SE EXPANDE AO LONGO DO LivroFisico, POIS SOMENTE EXISTE UMA VENDA SE EXISTE
    // UM ESTOQUE DE LIVROS FÍSICOS
    boolean vender();
}
