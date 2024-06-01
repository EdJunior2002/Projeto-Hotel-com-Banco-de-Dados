package servico;

import java.math.BigDecimal;
import java.util.Scanner;
import dao.QuartoDao;
import entidades.Quarto;

public class ServicoQuarto {

    public void cadastrarQuarto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite Tipo do Quarto (standard, master, mastersuperior): ");
        String tipo = sc.nextLine();

        BigDecimal valor;
        switch (tipo.toLowerCase()) {
            case "standard":
                valor = new BigDecimal("200.00");
                break;
            case "master":
                valor = new BigDecimal("300.00");
                break;
            case "mastersuperior":
                valor = new BigDecimal("500.00");
                break;
            default:
                System.out.println("Tipo de quarto inválido!");
                sc.close();
                return;
        }

        Quarto q = new Quarto();
        q.setTipoquarto(tipo);
        q.setValorquarto(valor);

        QuartoDao quartoDao = new QuartoDao();
        if (quartoDao.quartoExiste(tipo)) {
            quartoDao.atualizarQuantidadeQuarto(tipo);
            System.out.println("Quantidade de " + tipo + " atualizada com sucesso!");
        } else {
            quartoDao.cadastrarQuarto(q);
            System.out.println("Quarto cadastrado com sucesso!");
        }

        sc.close();
    }

    public void excluirQuarto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tipo do quarto que deseja excluir: ");
        String tipo = sc.nextLine();

        QuartoDao quartoDao = new QuartoDao();
        if (quartoDao.quartoExiste(tipo)) {
            quartoDao.reduzirQuantidadeQuarto(tipo);
            System.out.println("Quantidade de " + tipo + " reduzida com sucesso!");
        } else {
            System.out.println("Quarto não encontrado!");
        }

        sc.close();
    }
}
