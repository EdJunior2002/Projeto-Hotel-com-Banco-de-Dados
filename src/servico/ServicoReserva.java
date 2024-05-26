package servico;

import java.util.Scanner;
import entidades.Reserva;
import dao.ClienteDao;
import dao.ReservaDao;

public class ServicoReserva {

    public void cadastrarReserva() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CPF do Cliente: ");
        String cpf = sc.nextLine();

        ClienteDao clienteDao = new ClienteDao();

        if (clienteDao.clienteExiste(cpf)) {
            System.out.println("Digite o nome do Cliente: ");
            String nome = sc.nextLine();
            System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
            String datanascimento = sc.nextLine();
            System.out.println("Digite o telefone: ");
            String telefone = sc.nextLine();
            System.out.println("Digite o email: ");
            String email = sc.nextLine();
            System.out.println("Digite a data de início (dd/MM/yyyy): ");
            String datainicio = sc.nextLine();
            System.out.println("Digite a data de fim (dd/MM/yyyy): ");
            String datafim = sc.nextLine();
            System.out.println("Digite o tipo de quarto: ");
            String tipoquarto = sc.nextLine();
            System.out.println("Digite o tipo de pagamento: ");
            String tipagamento = sc.nextLine();

            Reserva reserva = new Reserva();
            reserva.setCpf(cpf);
            reserva.setNome(nome);
            reserva.setDatanascimento(datanascimento);
            reserva.setTelefone(telefone);
            reserva.setEmail(email);
            reserva.setDatainicio(datainicio);
            reserva.setDatafim(datafim);
            reserva.setTipoquarto(tipoquarto);
            reserva.setTipagamento(tipagamento);

            new ReservaDao().cadastrarReserva(reserva);

            System.out.println("Reserva cadastrada com sucesso!");
        } else {
            System.out.println("Cliente não encontrado. Cadastro não realizado.");
        }

        sc.close();
    }
}
