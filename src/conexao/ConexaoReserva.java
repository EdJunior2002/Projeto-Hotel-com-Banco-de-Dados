package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoReserva {

    private static final String url = "jdbc:mysql://localhost:3306/reserva"; // Alterado para o banco de dados de reserva
    private static final String user = "root";
    private static final String password = "admin";

    private static Connection conexao;

    public static Connection getConexao() {
        if (conexao == null || isConnectionClosed(conexao)) {
            try {
                conexao = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexao;
    }

    private static boolean isConnectionClosed(Connection conn) {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
