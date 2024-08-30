public class Gerente extends Funcionario{

    public Gerente(String nome, double salario){
        super(nome, salario);
        definirCargo();
    }

    @Override
    public void definirCargo(){
        this.cargo = "Gerente";
    }

    @Override
    public String toString(){
        return "Gerente [Nome: "+nome+", Salário: R$"+salario+"]";
    }

}
