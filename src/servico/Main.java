package servico;

import java.util.Scanner;
import dao.ClienteDao;
import dao.FuncionarioDao;
import dao.HotelDao;
import dao.QuartoDao;
import dao.ReservaDao;

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
        System.out.println("6 - Cadastrar Reserva");
        System.out.println("7 - Excluir Cliente");
        System.out.println("8 - Excluir Funcionário");
        System.out.println("9 - Excluir Hotel");
        System.out.println("10 - Reduzir Quantidade de Quarto");
        System.out.println("11 - Excluir Reserva");
        System.out.print("Opção: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

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
                cadastrarReserva();
                break;
            case 7:
                excluirCliente();
                break;
            case 8:
                excluirFuncionario();
                break;
            case 9:
                excluirHotel();
                break;
            case 10:
                reduzirQuantidadeQuarto();
                break;
            case 11:
                excluirReserva();
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

    public static void cadastrarReserva() {
        ServicoReserva servicoReserva = new ServicoReserva();
        servicoReserva.cadastrarReserva();
    }

    public static void cadastrarFuncionario() {
        ServicoFuncionario servicoFuncionario = new ServicoFuncionario();
        servicoFuncionario.cadastrarFuncionario();
    }

    public static void cadastrarHotel() {
        ServicoHotel servicoHotel = new ServicoHotel();
        servicoHotel.cadastrarHotel();
    }

    public static void cadastrarPagamento() {
        ServicoPagamento servicoPagamento = new ServicoPagamento();
        servicoPagamento.cadastrarPagamento();
    }

    public static void cadastrarQuarto() {
        ServicoQuarto servicoQuarto = new ServicoQuarto();
        servicoQuarto.cadastrarQuarto();
    }

    public static void excluirCliente() {
        ClienteDao clienteDao = new ClienteDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente a ser excluído: ");
        String cpf = sc.nextLine();
        clienteDao.excluirCliente(cpf);
        sc.close();
    }

    public static void excluirFuncionario() {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF do funcionário a ser excluído: ");
        String cpf = sc.nextLine();
        funcionarioDao.excluirFuncionario(cpf);
        sc.close();
    }

    public static void excluirHotel() {
        HotelDao hotelDao = new HotelDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CNPJ do hotel a ser excluído: ");
        String cnpj = sc.nextLine();
        hotelDao.excluirHotel(cnpj);
        sc.close();
    }

    public static void reduzirQuantidadeQuarto() {
        QuartoDao quartoDao = new QuartoDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do quarto a ser reduzida a quantidade: ");
        String codigo = sc.nextLine();
        quartoDao.reduzirQuantidadeQuarto(codigo);
        sc.close();
    }

    public static void excluirReserva() {
        ReservaDao reservaDao = new ReservaDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente cuja reserva será excluída: ");
        String cpf = sc.nextLine();
        reservaDao.excluirReserva(cpf);
        sc.close();
    }
}
