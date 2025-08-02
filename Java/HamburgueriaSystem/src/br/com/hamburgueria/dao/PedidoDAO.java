package br.com.hamburgueria.dao;

import br.com.hamburgueria.model.ItemPedido;
import br.com.hamburgueria.model.Pedido;
import java.sql.*;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {

    public void salvar(Pedido pedido) {
        String sqlPedido = "INSERT INTO pedidos (funcionario_id, total) VALUES (?, ?)";
        String sqlItem = "INSERT INTO pedido_itens (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();
            connection.setAutoCommit(false); // Inicia a transação

            // Salva o Pedido
            try (PreparedStatement stmtPedido = connection.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                stmtPedido.setInt(1, pedido.getFuncionario().getId());
                stmtPedido.setBigDecimal(2, pedido.getTotal());
                stmtPedido.executeUpdate();

                try (ResultSet generatedKeys = stmtPedido.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        pedido.setId(generatedKeys.getInt(1));
                    }
                }
            }

            // Salva os Itens do Pedido
            try (PreparedStatement stmtItem = connection.prepareStatement(sqlItem)) {
                for (ItemPedido item : pedido.getItens()) {
                    stmtItem.setInt(1, pedido.getId());
                    stmtItem.setInt(2, item.getProduto().getId());
                    stmtItem.setInt(3, item.getQuantidade());
                    stmtItem.setBigDecimal(4, item.getPrecoUnitario());
                    stmtItem.addBatch(); // Adiciona ao lote
                }
                stmtItem.executeBatch(); // Executa todos os inserts de uma vez
            }

            connection.commit(); // Confirma a transação
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback(); // Desfaz a transação em caso de erro
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public BigDecimal calcularTotalVendas() {
        String sql = "SELECT SUM(total) FROM pedidos";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    public int contarPedidos() {
        String sql = "SELECT COUNT(*) FROM pedidos";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}