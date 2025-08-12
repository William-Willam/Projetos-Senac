package App;

//importacao

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  //atributos
	private static final String URL = "jdbc:mysql://localhost:3307/Sistema_Clientes";
	private static final String USER = "root";
	private static final String SENHA = "senac";
	
	//tratamento de acesso
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, SENHA);
		} catch (SQLException erro) {
			erro.printStackTrace();
			return null;
		}
		
	}
}