package domain;

public class FuncionarioManager {
    private Funcionario[] funcionarios;
    private int totalFuncionarios;
    private int capacidade;

    public FuncionarioManager(int capacidade) {
        this.capacidade = capacidade;
        this.funcionarios = new Funcionario[capacidade];
        this.totalFuncionarios = 0;
    }

    public void cadastrarFuncionario() {
        if (totalFuncionarios >= capacidade) {
            System.out.println("Capacidade máxima de funcionários atingida.");
            return;
        }

        System.out.println("\n=== Cadastro de Funcionário ===");
        System.out.print("Matrícula: ");
        int matricula = Teclado.scanInt();
        Teclado.nextLine();

        System.out.print("Nome: ");
        String nome = Teclado.scanString();

        System.out.print("Salário: R$ ");
        double salario = Teclado.scanDouble();
        Teclado.nextLine();

        Funcionario novoFuncionario = new Funcionario(matricula, nome, salario);
        funcionarios[totalFuncionarios] = novoFuncionario;
        totalFuncionarios++;

        System.out.println("\nFuncionário cadastrado com sucesso.");
    }

    public void atualizarFuncionario() {
        if (totalFuncionarios == 0) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }

        System.out.println("\nDigite a matrícula do funcionário para atualizá-lo: ");
        int matricula = Teclado.scanInt();
        Teclado.nextLine();

        int indice = buscarIndicePorMatricula(matricula);
        if (indice == -1) {
            System.out.println("\nFuncionário não encontrado.\n");
            return;
        }

        System.out.println("\n=== Atualização de Funcionário ===");
        System.out.println("Novo nome (atual): " + funcionarios[indice].nome + "): ");
        String novoNome = Teclado.scanString();

        System.out.println("Novo salário (atual): " + funcionarios[indice].salario + "): R$ ");
        double novoSalario = Teclado.scanDouble();
        Teclado.nextLine();

        funcionarios[indice].nome = novoNome;
        funcionarios[indice].salario = novoSalario;

        System.out.println("\nFuncionário atualizado com sucesso.");
    }

    public void excluirFuncionario() {
        if (totalFuncionarios == 0) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }

        System.out.println("\n=== Exclusão de Funcionário ===");
        int matricula = Teclado.scanInt();


        int indice = buscarIndicePorMatricula(matricula);

        for (int i = indice; i < totalFuncionarios - 1; i++) {
            funcionarios[i] = funcionarios[i + 1];
        }

        funcionarios[totalFuncionarios - 1] = null;
        totalFuncionarios--;
        System.out.println("\nFuncionário excluído com sucesso.");
    }

    public void consultarTodosFuncionario() {
        if (totalFuncionarios == 0) {
            System.out.println("Não há funcionários cadastrados.");
            return;
        }

        System.out.println("\n=== Lista de Funcionários ===");
        for (int i = 0; i < totalFuncionarios; i++) {
            Funcionario f = funcionarios[i];
            System.out.println("Matrícula: " + f.matricula);
            System.out.println("Nome.....: " + f.nome);
            System.out.println("Salário..: R$ " + f.salario);
            System.out.println("----------------------------");
        }
        System.out.println();
    }

    private int buscarIndicePorMatricula(int matricula) {
        for (int i = 0; i < totalFuncionarios; i++) {
            if (funcionarios[i].matricula == matricula) {
                return i;
            }
        }
        return -1;
    }
}
