package br.com.loginapp;

import java.sql.*;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3307/Login";
	private static final String USUARIO = "root";
	private static final String SENHA = "senac";

	public static Connection conectar() {
		Connection conexao = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conectado ao banco de dados!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC não encontrado: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar: " + e.getMessage());
		}
		return conexao;

	}

}
