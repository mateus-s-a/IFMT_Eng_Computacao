public class Menu {
    public static void menuPrincipal() {
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
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
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
