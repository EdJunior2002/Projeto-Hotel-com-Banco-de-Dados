package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import conexao.ConexaoFuncionario;
import entidades.Funcionario;

public class FuncionarioDao {

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (!isMaiorDeIdade(funcionario.getDataNascimento())) {
            System.out.println("Funcionário não pode ser cadastrado. Deve ter 18 anos ou mais.");
            return;
        }

        String sql = "INSERT INTO FUNCIONARIOO (NOME, CPF, DATANASCIMENTO, TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoFuncionario.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(4, funcionario.getTelefone());
            ps.setString(5, funcionario.getEmail());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean funcionarioExiste(String cpf) {
        String sql = "SELECT COUNT(*) FROM FUNCIONARIOO WHERE CPF = ?";
        try (Connection conn = ConexaoFuncionario.getConexao();
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

    public void excluirFuncionario(String cpf) {
        String sql = "DELETE FROM FUNCIONARIOO WHERE CPF = ?";
        try (Connection conn = ConexaoFuncionario.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.executeUpdate();
            System.out.println("Funcionário excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isMaiorDeIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears() >= 18;
    }
}
