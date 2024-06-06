
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

        System.out.println("Digite o nome do Cliente: ");
        String nome = sc.nextLine();

        String cpf = null;
        while (cpf == null) {
            System.out.println("Digite o CPF do Cliente (somente números): ");
            String cpfInput = sc.nextLine();
            if (cpfInput.matches("\\d{11}")) {
                cpf = cpfInput;
            } else {
                System.out.println("CPF não possui 11 caracteres, tente novamente.");
            }
        }

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

        ClienteDao clienteDao = new ClienteDao();
        if (clienteDao.clienteExiste(cpf)) {
            System.out.println("Cliente com este CPF já existe. Cadastro não realizado.");
        } else {
            clienteDao.cadastrarCliente(c);
            System.out.println("Cliente cadastrado com sucesso!");
        }

        sc.close();
    }

    private boolean temIdadeValida(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(dataNascimento, hoje);
        return idade.getYears() >= 18;
    }
}