public class FuncionarioManager {
    public static int proximaMatricula = 1; // para que a matrícula seja única em cada cadastro e sem necessidade de inserção vinda do usuário

    public static void insercaoFuncionario(Funcionario[] funcionarios) {
        System.out.println("\n=== INSERÇÃO ===\n");

        // criar uma posição de error para procurar uma posição disponível no array de funcionários
        int posicao = -1;
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] == null) { // tenta encontrar uma posição vazia (null)
                posicao = i; // ao encontrar, pega esta posição
                break;
            }
        }

        // caso não encontre uma posição vazia
        if (posicao == -1) {
            System.out.println("Não há espaços para novos funcionários.\n");
            return;
        }

        // coletar os dados de Nome e Salário e armazená-los para serem recebidos no array posteriormente
        String nome = Teclado.lerString("Nome do(a) funcionário(a): ");
        double salario = Teclado.lerDouble("Salário do(a) funcionário(a): ");

        // cria um novo funcionário do tipo Funcionário, com o operador (new) é usado o construtor para armazenar as informações anteriormente salvas
        Funcionario novoFuncionario = new Funcionario(proximaMatricula, nome, salario);

        // o verdadeiro array de funcionários recebe agora este funcionário na posição vazia (null)
        funcionarios[posicao] = novoFuncionario;

        System.out.println("\nFuncionário cadastrado com sucesso.\n");
        System.out.println("Matrícula: " + proximaMatricula);
        proximaMatricula++;
    }

    public static void atualizacaoFuncionario(Funcionario[] funcionarios) {
        System.out.println("\n=== ATUALIZAÇÃO ===\n");
        int getMatricula = Teclado.lerInteiro("Matrícula a ser atualizada: ");

        int posicao = -1;
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null &&funcionarios[i].matricula == getMatricula) {
                posicao = i;
                break;
            }
        }

        if (posicao == -1) {
            System.out.println("Funcionário não encontrado.\n");
            return;
        }

        String novoNome = Teclado.lerString("Novo nome: ");
        double novoSalario = Teclado.lerDouble("Novo salário: ");

        funcionarios[posicao].nome = novoNome;
        funcionarios[posicao].salario = novoSalario;

        System.out.println("\nFuncionário atualizado com sucesso.\n");
    }

    public static void exclusaoFuncionario(Funcionario[] funcionarios) {
        System.out.println("\n=== EXCLUSÃO ===\n");
        int getMatricula = Teclado.lerInteiro("Matrícula para exclusão: ");

        int posicao = -1;
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null && funcionarios[i].matricula == getMatricula) {
                posicao = i;
                break;
            }
        }

        if (posicao == -1) {
            System.out.println("Funcionário não encontrado.\n");
            return;
        }

        funcionarios[posicao] = null; // deixa o funcionário como (null), ou seja, indisponível para acessá-lo (excluído)
        System.out.println("\nFuncionário excluído com sucesso.\n");
    }

    public static void consultaFuncionario(Funcionario[] funcionarios) {
        System.out.println("\n=== CONSULTA ===\n");
        int getMatricula = Teclado.lerInteiro("Matrícula para consulta: ");

        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null && funcionario.matricula == getMatricula) {
                System.out.println("\nMatrícula: " + funcionario.matricula);
                System.out.println("Nome.....: " + funcionario.nome);
                System.out.println("Salário..: R$ " + funcionario.salario);
                return;
            }
        }

        System.out.println("Funcionário não encontrado.\n");
    }
}
