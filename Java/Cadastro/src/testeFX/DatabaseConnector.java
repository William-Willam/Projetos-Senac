package testeFX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
    // URL de conexão com o banco de dados. Altere se necessário.
    private static final String URL = "jdbc:mysql://localhost:3306/pessoas";
    private static final String USUARIO = "root"; // Altere para seu usuário
    private static final String SENHA = "Willis@2096@"; // Altere para sua senha

    public static Connection getConnection() throws SQLException {
        // Retorna a conexão com o banco de dados
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void adicionarPessoa(Pessoas pessoa) {
        // SQL para inserir uma nova pessoa
        String sql = "INSERT INTO pessoas (nome, idade) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());

            stmt.executeUpdate();
            System.out.println("Pessoa adicionada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Pessoas> listarPessoas() {
        List<Pessoas> pessoas = new ArrayList<>();
        // SQL para selecionar todas as pessoas
        String sql = "SELECT * FROM pessoas";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                pessoas.add(new Pessoas(id, nome, idade));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }
    
    public static void atualizarPessoa(Pessoas pessoa) {
        // SQL para atualizar uma pessoa com base no ID
        String sql = "UPDATE pessoas SET nome = ?, idade = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setInt(3, pessoa.getId());
            
            stmt.executeUpdate();
            System.out.println("Pessoa atualizada com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void apagarPessoa(int id) {
        // SQL para apagar uma pessoa com base no ID
        String sql = "DELETE FROM pessoas WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            System.out.println("Pessoa apagada com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}