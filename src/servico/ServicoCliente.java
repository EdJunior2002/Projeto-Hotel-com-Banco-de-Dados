package servico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.Scanner;
import entidades.Cliente;
import dao.ClienteDao;

public class ServicoCliente {

    public void cadastrarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite nome do Cliente: ");
        String nome = sc.nextLine();
        System.out.println("Digite o CPF do Cliente: ");
        String cpf = sc.nextLine();
        LocalDate dataNascimento = null;

        while (dataNascimento == null) {
            System.out.println("Digite a data de nascimento do Cliente (dd/MM/yyyy): ");
            String dt = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                dataNascimento = LocalDate.parse(dt, formatter);    
            } catch (DateTimeParseException e) {
                System.out.println("Data de nascimento inválida. Tente novamente.");
            }
        }

        if (!temIdadeValida(dataNascimento)) {
            System.out.println("Cliente deve ter 18 anos ou mais. Cadastro não realizado.");
            sc.close();
            return;
        }

        System.out.println("Digite o telefone do Cliente: ");
        String telefone = sc.nextLine();
        System.out.println("Digite o email do Cliente: ");
        String email = sc.nextLine();

        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.setDataNascimento(dataNascimento);
        c.setTelefone(telefone);
        c.setEmail(email);

        new ClienteDao().cadastrarCliente(c);

        System.out.println("Cliente cadastrado com sucesso!");

        sc.close();
    }

    private boolean temIdadeValida(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(dataNascimento, hoje);
        return idade.getYears() >= 18;
    }
}
