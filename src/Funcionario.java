public abstract class Funcionario {

    protected String nome;
    protected double salario;
    protected String cargo;

    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public abstract void definirCargo();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public abstract String toString();

}
