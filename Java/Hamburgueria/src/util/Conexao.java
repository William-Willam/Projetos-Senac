package util;

import java.sql.Connection;
import java.sql.DriverManager;

// conexao ao banco de dados
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost/hamburgueria";
    private static final String USER = "root";
    private static final String PASSWORD = "Willis@2096@";

    public static Connection conectar() {
        try {
        	System.out.println("Acesso ao banco hamburgueria !!! ");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}
