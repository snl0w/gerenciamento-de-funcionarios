public class Operador extends Funcionario{

    public Operador(String nome, double salario){
        super(nome, salario);
        definirCargo();
    }

    @Override
    public void definirCargo(){
        this.cargo = "Operador";
    }

    @Override
    public String toString(){
        return "Operador [Nome: "+nome+", Salário: R$"+salario+"]";
    }

}

