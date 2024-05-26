package servico;

import java.util.Scanner;
import dao.ClienteDao;
import dao.FuncionarioDao;
import dao.HotelDao; // Importe o DAO do Hotel
import dao.QuartoDao; // Importe o DAO do Quarto
import dao.ReservaDao; // Importe o DAO da Reserva

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de cadastro!");
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Funcionário");
        System.out.println("3 - Cadastrar Quarto");
        System.out.println("4 - Cadastrar Pagamento");
        System.out.println("5 - Cadastrar Hotel");
        System.out.println("6 - Excluir Cliente");
        System.out.println("7 - Excluir Funcionário");
        System.out.println("8 - Excluir Hotel");
        System.out.println("9 - Excluir Quarto");
        System.out.println("10 - Excluir Reserva"); // Adicionando a opção de excluir reserva
        System.out.print("Opção: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                cadastrarFuncionario();
                break;
            case 3:
                cadastrarQuarto();
                break;
            case 4:
                cadastrarPagamento();
                break;
            case 5:
                cadastrarHotel();
                break;
            case 6:
                excluirCliente();
                break;
            case 7:
                excluirFuncionario();
                break;
            case 8:
                excluirHotel();
                break;
            case 9:
                excluirQuarto();
                break;
            case 10:
                excluirReserva(); // Chamar o método para excluir reserva
                break;
            default:
                System.out.println("Opção inválida!");
        }
        
        scanner.close();
    }

    public static void cadastrarCliente() {
        ServicoCliente servicoCliente = new ServicoCliente();
        servicoCliente.cadastrarCliente();
    }

    public static void cadastrarFuncionario() {
        ServicoFuncionario servicoFuncionario = new ServicoFuncionario();
        servicoFuncionario.cadastrarFuncionario();
    }

    public static void cadastrarQuarto() {
        ServicoQuarto servicoQuarto = new ServicoQuarto();
        servicoQuarto.cadastrarQuarto();
    }

    public static void cadastrarPagamento() {
        ServicoPagamento servicoPagamento = new ServicoPagamento();
        servicoPagamento.cadastrarPagamento();
    }

    public static void cadastrarHotel() {
        ServicoHotel servicoHotel = new ServicoHotel();
        servicoHotel.cadastrarHotel();
    }

    public static void excluirCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente a ser excluído: ");
        String cpf = scanner.nextLine();
        ClienteDao clienteDao = new ClienteDao();
        if (clienteDao.clienteExiste(cpf)) {
            clienteDao.excluirCliente(cpf);
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
        scanner.close();
    }

    public static void excluirFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do funcionário a ser excluído: ");
        String cpf = scanner.nextLine();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        if (funcionarioDao.funcionarioExiste(cpf)) {
            funcionarioDao.excluirFuncionario(cpf);
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
        scanner.close();
    }

    public static void excluirHotel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CNPJ do hotel a ser excluído: ");
        String cnpj = scanner.nextLine();
        HotelDao hotelDao = new HotelDao();
        if (hotelDao.hotelExiste(cnpj)) {
            hotelDao.excluirHotel(cnpj);
            System.out.println("Hotel excluído com sucesso!");
        } else {
            System.out.println("Hotel não encontrado!");
        }
        scanner.close();
    }

    public static void excluirQuarto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tipo do quarto a ser excluído: ");
        String tipo = scanner.nextLine();
        QuartoDao quartoDao = new QuartoDao();
        if (quartoDao.quartoExiste(tipo)) {
            quartoDao.excluirQuarto(tipo);
            System.out.println("Quarto excluído com sucesso!");
        } else {
            System.out.println("Quarto não encontrado!");
        }
        scanner.close();
    }

    public static void excluirReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF do titular da reserva a ser excluída: ");
        String cpf = scanner.nextLine();
        ReservaDao reservaDao = new ReservaDao();
        if (reservaDao.reservaExiste(cpf)) {
            reservaDao.excluirReserva(cpf);
            System.out.println("Reserva excluída com sucesso!");
        } else {
            System.out.println("Reserva não encontrada!");
        }
        scanner.close();
    }
}
