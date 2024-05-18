public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Ana", 50.0, 160);
        Lider l1 = new Lider("Bruno", 60.0, 160);
        Gerente g1 = new Gerente("Carla", 80.0, 160);

        System.out.println(f1.nome + ": " + f1.calcularSalario());
        System.out.println(l1.nome + ": " + l1.calcularSalario());
        System.out.println(g1.nome + ": " + g1.calcularSalario());
    }
}

class Funcionario {
    protected String nome;
    protected double valorHora;
    protected int horasTrabalhadas;

    public Funcionario(String nome, double valorHora, int horasTrabalhadas) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double calcularSalario() {
        return valorHora * horasTrabalhadas;
    }
}

class Lider extends Funcionario {
    public Lider(String nome, double valorHora, int horasTrabalhadas) {
        super(nome, valorHora, horasTrabalhadas);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * 1.02;
    }
}

class Gerente extends Funcionario {
    public Gerente(String nome, double valorHora, int horasTrabalhadas) {
        super(nome, valorHora, horasTrabalhadas);
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * 1.05;
    }
}

