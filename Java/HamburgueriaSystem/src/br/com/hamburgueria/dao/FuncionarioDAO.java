package br.com.hamburgueria.dao;

import br.com.hamburgueria.model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    /**
     * Salva um novo funcionário no banco de dados.
     * @param funcionario O objeto Funcionario a ser salvo.
     */
    public void salvar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, usuario, senha, is_admin) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setBoolean(4, funcionario.isAdmin());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    funcionario.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca um funcionário pelo seu ID.
     * @param id O ID do funcionário.
     * @return O objeto Funcionario se encontrado, ou null caso contrário.
     */
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("usuario"),
                        rs.getString("senha"),
                        rs.getBoolean("is_admin")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Busca um funcionário pelo seu nome de usuário.
     * @param usuario O nome de usuário do funcionário.
     * @return O objeto Funcionario se encontrado, ou null caso contrário.
     */
    public Funcionario buscarPorUsuario(String usuario) {
        String sql = "SELECT * FROM funcionarios WHERE usuario = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("usuario"),
                        rs.getString("senha"),
                        rs.getBoolean("is_admin")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Atualiza os dados de um funcionário no banco de dados.
     * @param funcionario O objeto Funcionario com os dados atualizados.
     */
    public void atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome = ?, usuario = ?, senha = ?, is_admin = ? WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setBoolean(4, funcionario.isAdmin());
            stmt.setInt(5, funcionario.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exclui um funcionário do banco de dados.
     * @param id O ID do funcionário a ser excluído.
     */
    public void excluir(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os funcionários.
     * @return Uma lista de objetos Funcionario.
     */
    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("usuario"),
                    rs.getString("senha"),
                    rs.getBoolean("is_admin")
                );
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}