package servico;

import java.util.Scanner;
import entidades.Pagamento;
import dao.PagamentoDao;

public class ServicoPagamento {
    public void cadastrarPagamento() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite Tipo de pagamento: ");
        String tipo = sc.nextLine();
        System.out.println("Digite o valor do pagamento: ");
        String valor = sc.nextLine();

        Pagamento p = new Pagamento();
        p.setTipo_do_pagamento(tipo);
        p.setValor_do_pagamento(valor);

        new PagamentoDao().cadastrarPagamento(p);

     

        sc.close();
    }
}
