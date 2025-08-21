package br.com.loginapp;

import java.sql.*;

public class UsuarioDAO {

	public boolean autenticar(Usuario usuario) {
		String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";

		try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			System.out.println("Erro ao conectar: "+e.getMessage());
			return false;
		}
	}

}
