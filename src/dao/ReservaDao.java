package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConexaoReserva;
import conexao.ConexaoCliente;
import entidades.Reserva;

public class ReservaDao {

    private QuartoDao quartoDao = new QuartoDao(); 

    public void cadastrarReserva(Reserva reserva) {
        String sql = "INSERT INTO RESERVAA (CPF, NOME, DATANASCIMENTO, TELEFONE, EMAIL, DATAINICIO, DATAFIM, TIPOQUARTO, TIPOPAGAMENTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoReserva.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, reserva.getCpf());
            ps.setString(2, reserva.getNome());
            ps.setString(3, reserva.getDatanascimento());
            ps.setString(4, reserva.getTelefone());
            ps.setString(5, reserva.getEmail());
            ps.setString(6, reserva.getDatainicio());
            ps.setString(7, reserva.getDatafim());
            ps.setString(8, reserva.getTipoquarto());
            ps.setString(9, reserva.getTipagamento());

            ps.execute();

            quartoDao.reduzirQuantidadeQuarto(reserva.getTipoquarto());

        } catch (SQLException e) {
            e.printStackTrace();    
        }
    }

    public boolean clienteExiste(String cpf) {
        String sql = "SELECT COUNT(*) FROM CLIENTEE WHERE CPF = ?";
        try (Connection conn = ConexaoCliente.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void excluirReserva(String cpf) {
        String sql = "DELETE FROM RESERVAA WHERE CPF = ?";
        String tipoQuarto = "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConexaoReserva.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reserva excluída com sucesso!");

                tipoQuarto = getTipoQuartoByCpf(cpf);

                if (!tipoQuarto.isEmpty()) {
                    quartoDao.aumentarQuantidadeQuarto(tipoQuarto);
                }
            } else {
                System.out.println("Nenhuma reserva encontrada com o CPF fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String getTipoQuartoByCpf(String cpf) {
        String sql = "SELECT TIPOQUARTO FROM RESERVAA WHERE CPF = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String tipoQuarto = "";

        try {
            conn = ConexaoReserva.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if (rs.next()) {
                tipoQuarto = rs.getString("TIPOQUARTO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tipoQuarto;
    }
}