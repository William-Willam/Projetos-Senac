package br.com.hamburgueria.dao;

import br.com.hamburgueria.model.Produto;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, preco) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getPreco());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produto.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getBigDecimal("preco")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.setInt(4, produto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getBigDecimal("preco")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}