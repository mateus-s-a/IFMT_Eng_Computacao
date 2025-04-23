public class Menu {
    public static void menuPrincipal(Funcionario[] funcionarios) {
        int opcao;

        do {
            System.out.println("=== MENU ===");
            System.out.print("\n1. Inserção");
            System.out.print("\n2. Atualização");
            System.out.print("\n3. Exclusão");
            System.out.print("\n4. Consulta");
            System.out.print("\n0. Sair");
            opcao = Teclado.lerInteiro("\nEscolha uma opção: ");

            switch (opcao) {
                case 1:
                    FuncionarioManager.insercaoFuncionario(funcionarios); // passará o array de funcionários para receber o novo funcionário inserido
                    break;

                case 2:
                    FuncionarioManager.atualizacaoFuncionario(funcionarios);
                    break;

                case 3:
                    FuncionarioManager.exclusaoFuncionario(funcionarios);
                    break;

                case 4:
                    FuncionarioManager.consultaFuncionario(funcionarios);
                    break;

                case 0:
                    System.out.println("\nSaindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida.\n");
                    break;
            }
        } while (opcao != 0);
    }
}
