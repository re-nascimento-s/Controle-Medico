package controlemedico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica"; 
    private static final String USUARIO = "root"; // Seu usuário do MySQL
    private static final String SENHA = ""; // Sua senha do MySQL

    public static Connection conectar() throws SQLException {
        try {
            // Carrega o driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado.", e);
        }
    }
}