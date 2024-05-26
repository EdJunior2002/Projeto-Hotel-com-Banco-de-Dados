package servico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.Scanner;
import entidades.Funcionario;
import dao.FuncionarioDao;

public class ServicoFuncionario {

    public void cadastrarFuncionario() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite nome do Funcionário: ");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF do Funcionário: ");
        String cpf = sc.nextLine();
        LocalDate dataNascimento = null;

        while (dataNascimento == null) {
            System.out.println("Digite a data de nascimento do Funcionário (dd/MM/yyyy): ");
            String dt = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                dataNascimento = LocalDate.parse(dt, formatter);    
            } catch (DateTimeParseException e) {
                System.out.println("Data de nascimento inválida. Tente novamente.");
            }
        }

        if (!temIdadeValida(dataNascimento)) {
            System.out.println("Funcionário deve ter 18 anos ou mais. Cadastro não realizado.");
            sc.close();
            return;
        }

        System.out.println("Digite o telefone do Funcionário: ");
        String telefone = sc.nextLine();
        System.out.println("Digite o email do Funcionário: ");
        String email = sc.nextLine();

        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setCpf(cpf);
        f.setDataNascimento(dataNascimento);
        f.setTelefone(telefone);
        f.setEmail(email);

        new FuncionarioDao().cadastrarFuncionario(f);

        System.out.println("Funcionário cadastrado com sucesso!");

        sc.close();
    }

    private boolean temIdadeValida(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(dataNascimento, hoje);
        return idade.getYears() >= 18;
    }
}
