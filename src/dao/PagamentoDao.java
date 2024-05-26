package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.ConexaoPagamento;
import entidades.Pagamento;

public class PagamentoDao {

    public void cadastrarPagamento (Pagamento pagamento) {

        String sql = "INSERT INTO PAGAMENTOO (TIPOPAGAMENTO, VALORPAGAMENTO) VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
            ps = ConexaoPagamento.getConexao().prepareStatement(sql);
            ps.setString(1, pagamento.getTipo_do_pagamento());
            ps.setString(2, pagamento.getValor_do_pagamento());

            ps.execute();
            ps.close();
        }

        catch (SQLException e) {
            e.printStackTrace();    
        } 


       
    }


    
}
