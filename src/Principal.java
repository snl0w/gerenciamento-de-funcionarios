import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class Principal {

    private static final String FILE_PATH = "funcionarios.txt";

    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        boolean running = true;

        while(running){
            System.out.println("---Menu de Gerenciamento de Funcionários--|");
            System.out.println("|1. Cadastrar Funcionário                 |");
            System.out.println("|2. Visualizar Funcionários Ordenados     |");
            System.out.println("|3. Sair                                  |");
            System.out.println("Escolha uma opção: ");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao){
                case 1:
                    cadastrarFuncionario(leitor, funcionarios);
                    break;
                case 2:
                    visualzarFuncionarios(funcionarios);
                    break;
                case 3:
                    running = false;
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        leitor.close();
    }

    private static void cadastrarFuncionario(Scanner leitor, ArrayList<Funcionario> funcionarios){
        System.out.println("Digite 1 para cadastrar Gerente.");
        System.out.println("Digite 2 para cadastrar Operador.");

        int tipoFuncionario = leitor.nextInt();
        leitor.nextLine();

        System.out.println("Digite o nome do funcionário: ");
        String nome = leitor.nextLine();

        System.out.println("Digite o salário do funcionário: ");
        double salario = leitor.nextDouble();
        leitor.nextLine();

        Funcionario funcionario;

        if(tipoFuncionario == 1){
            funcionario = new Gerente(nome, salario);
        } else if (tipoFuncionario == 2){
            funcionario = new Operador(nome, salario);
        } else {
            System.out.println("Tipo de funcionário inválido.");
            return;
        }

        funcionarios.add(funcionario);
        salvarFuncionarioTxt(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void visualzarFuncionarios(ArrayList<Funcionario> funcionarios){
        if(funcionarios.isEmpty()){
            System.out.println("Nenhum funcionário cadastrado");
            return;
        }

        bubbleSort(funcionarios);

        System.out.println("Funcionários ordenados por nome: ");
        for (Funcionario func : funcionarios) {
            System.out.println(func);
        }
    }

    private static void bubbleSort(ArrayList<Funcionario> list) {
        int n = list.size();
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(list.get(j).getNome().compareTo(list.get(j + 1).getNome()) > 0){
                    Funcionario temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    private static void salvarFuncionarioTxt(Funcionario funcionario){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(FILE_PATH, true))){
            escritor.write(funcionario.toString());
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados do funcionário: "+e.getMessage());
        }
    }

}
