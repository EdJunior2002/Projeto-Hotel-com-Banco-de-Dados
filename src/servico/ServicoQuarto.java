package servico;

import java.util.Scanner;
import entidades.Quarto;
import dao.QuartoDao;

public class ServicoQuarto {

    
        public void cadastrarQuarto() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite Tipo do Quarto: ");
        String tipo = sc.nextLine();
        System.out.println("Digite o valor do quarto");
        String valor = sc.nextLine();

        Quarto q = new Quarto();
        q.setTipoquarto(tipo);
        q.setValorquarto(valor);

        new QuartoDao().cadastrarQuarto(q);

        System.out.println("Quarto cadastrado com sucesso!");

        sc.close();
    }
}
