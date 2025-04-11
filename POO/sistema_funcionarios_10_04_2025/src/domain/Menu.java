package domain;

public class Menu {
    public void exibirMenu() {
        int opcao;

        do {
            System.out.print("1. Cadastrar Funcionário\n");
            System.out.print("2. Atualizar Funcionário\n");
            System.out.print("3. Excluir Funcionário\n");
            System.out.print("4. Consultar Todos Funcionários\n");
            System.out.print("5. Sair\n");
            System.out.print("Opção: ");
            opcao = Teclado.scanInt();
            Teclado.nextLine();

            switch (opcao) {
                case 1:
                    Funcionario.cadastrarFuncionario();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nOpção inválida.\n");
                    break;
            }
        } while (opcao != 5);
    }
}
