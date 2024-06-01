package servico;

import java.util.Scanner;
import dao.ReservaDao;
import entidades.Reserva;

public class ServicoReserva {

    public void cadastrarReserva() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados da reserva:");
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de Início (AAAA-MM-DD): ");
        String dataInicio = sc.nextLine();
        System.out.print("Data de Fim (AAAA-MM-DD): ");
        String dataFim = sc.nextLine();
        System.out.print("Tipo de Quarto: ");
        String tipoQuarto = sc.nextLine();
        System.out.print("Tipo de Pagamento: ");
        String tipoPagamento = sc.nextLine();

        Reserva reserva = new Reserva();
        reserva.setCpf(cpf);
        reserva.setNome(nome);
        reserva.setDatanascimento(dataNascimento);
        reserva.setTelefone(telefone);
        reserva.setEmail(email);
        reserva.setDatainicio(dataInicio);
        reserva.setDatafim(dataFim);
        reserva.setTipoquarto(tipoQuarto);
        reserva.setTipagamento(tipoPagamento);

        ReservaDao reservaDao = new ReservaDao();
        reservaDao.cadastrarReserva(reserva);

        sc.close();
    }

    public void excluirReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF da reserva que deseja excluir: ");
        String cpf = sc.nextLine();

        ReservaDao reservaDao = new ReservaDao();
        reservaDao.excluirReserva(cpf);

        sc.close();
    }
}
