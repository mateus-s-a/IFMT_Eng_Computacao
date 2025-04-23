public class FuncionarioManager {
    public static void insercaoFuncionario() {
        System.out.println("\n=== INSERÇÃO ===\n");
        Teclado.lerString("Nome do(a) funcionário(a): ");
        Teclado.lerDouble("Salário do(a) funcionário(a): ");
    }

    public static void atualizacaoFuncionario() {
        System.out.println("\n=== ATUALIZAÇÃO ===\n");
        Teclado.lerString("Novo nome: ");
        Teclado.lerDouble("Novo salário: ");
    }

    public static void exclusaoFuncionario() {
        System.out.println("\n=== EXCLUSÃO ===\n");
        Teclado.lerInteiro("Matrícula para exclusão: ");
    }

    public static void consultaFuncionario() {
        System.out.println("\n=== CONSULTA ===\n");
        Teclado.lerInteiro("Matrícula para consulta: ");
    }
}
