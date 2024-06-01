package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConexaoQuarto;
import entidades.Quarto;

public class QuartoDao {

    public boolean quartoExiste(String tipoQuarto) {
        String sql = "SELECT COUNT(*) FROM QUARTO WHERE TIPO = ?";
        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipoQuarto);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void cadastrarQuarto(Quarto quarto) {
        String sql = "INSERT INTO QUARTO (TIPO, QUANTIDADE, VALOR) VALUES (?, 1, ?)";
        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, quarto.getTipoquarto());
            ps.setBigDecimal(2, quarto.getValorquarto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarQuantidadeQuarto(String tipoQuarto) {
        String sql = "UPDATE QUARTO SET QUANTIDADE = QUANTIDADE + 1 WHERE TIPO = ?";
        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipoQuarto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reduzirQuantidadeQuarto(String tipoQuarto) {
        String sql = "UPDATE QUARTO SET QUANTIDADE = QUANTIDADE - 1 WHERE TIPO = ? AND QUANTIDADE > 0";
        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipoQuarto);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Quantidade de quartos do tipo " + tipoQuarto + " reduzida com sucesso.");
            } else {
                System.out.println("Nenhum quarto do tipo " + tipoQuarto + " disponível para redução.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao reduzir quantidade de quartos: " + e.getMessage());
        }
    }

    public void aumentarQuantidadeQuarto(String tipoQuarto) {
        String sql = "UPDATE QUARTO SET QUANTIDADE = QUANTIDADE + 1 WHERE TIPO = ?";
        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipoQuarto);
            ps.executeUpdate();
            System.out.println("Quantidade de quartos do tipo " + tipoQuarto + " aumentada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao aumentar quantidade de quartos: " + e.getMessage());
        }
    }
}
