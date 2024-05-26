package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import conexao.ConexaoCliente;
import entidades.Cliente;

public class ClienteDao {

    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO CLIENTEE (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoCliente.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setDate(3, Date.valueOf(cliente.getDataNascimento()));
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getEmail());

            ps.execute();
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

    public void excluirCliente(String cpf) {
        String sql = "DELETE FROM CLIENTEE WHERE CPF = ?";
        try (Connection conn = ConexaoCliente.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o CPF fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
