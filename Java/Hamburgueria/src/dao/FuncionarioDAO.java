package dao;

// importaçao 
import java.sql.*;
import model.Funcionario;
import util.Conexao;

public class FuncionarioDAO {
	// ler no banco de dados e confirmar se existe as informações
    public boolean autenticar(String usuario, String senha) {
        String sql = "SELECT * FROM funcionarios WHERE usuario = ? AND senha = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

    // inseri no banco de dados
    public boolean cadastrar(Funcionario f) {
        String sql = "INSERT INTO funcionarios (nome, usuario, senha, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getUsuario());
            stmt.setString(3, f.getSenha());
            stmt.setString(4, f.getTipo());
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
}
