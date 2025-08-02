package br.com.hamburgueria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Dados de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/hamburgueria";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Willis@2096@";

    /**
     * Estabelece e retorna uma nova conexão com o banco de dados.
     * @return Uma nova conexão JDBC.
     * @throws SQLException Se ocorrer um erro ao conectar ao banco de dados.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Carrega o driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Retorna a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            // Lança uma exceção se o driver não for encontrado
            throw new SQLException("Driver JDBC do MySQL não encontrado!", e);
        }
    }

    /**
     * Fecha uma conexão JDBC.
     * @param connection A conexão a ser fechada.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}