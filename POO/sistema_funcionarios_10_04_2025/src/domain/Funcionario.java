package domain;

public class Funcionario {
    public int matricula;
    public String nome;
    public double salario;

    public Funcionario(int matricula, String nome, double salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
    }

    public static void cadastrarFuncionario() {
        System.out.println("Matricula: ");
        int matricula = Teclado.scanInt();
        Teclado.nextLine();

        System.out.println("Nome: ");
        String nome = Teclado.scanString();

        System.out.println("Salário: R$ ");
        double salario = Teclado.scanDouble();
        Teclado.nextLine();

        new Funcionario(matricula, nome, salario);
    }
}
