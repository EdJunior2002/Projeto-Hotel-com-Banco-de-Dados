package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoQuarto;
import entidades.Quarto;

public class QuartoDao {

    public void cadastrarQuarto(Quarto quarto) {

        String sql = "INSERT INTO QUARTOS (TIPOQUARTO, VALORQUARTO) VALUES (?, ?)";

        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, quarto.getTipoquarto());
            ps.setString(2, quarto.getValorquarto());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean quartoExiste(String tipo) {
        String sql = "SELECT COUNT(*) FROM QUARTOS WHERE TIPOQUARTO = ?";
        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void excluirQuarto(String tipo) {
        String sql = "DELETE FROM QUARTOS WHERE TIPOQUARTO = ?";
        try (Connection conn = ConexaoQuarto.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipo);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Quarto excluído com sucesso!");
            } else {
                System.out.println("Nenhum quarto encontrado com o tipo fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
