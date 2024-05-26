package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoHotel;
import entidades.Hotel;

public class HotelDao {

    public void cadastrarHotel(Hotel hotel) {
        String sql = "INSERT INTO HOTELL ( CNPJ,NOME, RUA, BAIRRO, CEP, COMPLEMENTO, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoHotel.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, hotel.getCnpj());
            ps.setString(2, hotel.getNome());
            ps.setString(3, hotel.getRua());
            ps.setString(4, hotel.getBairro());
            ps.setString(5, hotel.getCep());
            ps.setString(6, hotel.getComplemento());
            ps.setString(7, hotel.getEstado());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hotelExiste(String cnpj) {
        String sql = "SELECT COUNT(*) FROM HOTELL WHERE CNPJ = ?";
        try (Connection conn = ConexaoHotel.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void excluirHotel(String cnpj) {
        String sql = "DELETE FROM HOTELL WHERE CNPJ = ?";
        try (Connection conn = ConexaoHotel.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cnpj);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hotel excluído com sucesso!");
            } else {
                System.out.println("Nenhum hotel encontrado com o CNPJ fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
