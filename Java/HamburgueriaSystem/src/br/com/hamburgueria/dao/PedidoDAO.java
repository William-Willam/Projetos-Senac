package br.com.hamburgueria.dao;

import br.com.hamburgueria.model.ItemPedido;
import br.com.hamburgueria.model.Pedido;
import br.com.hamburgueria.model.Cliente;
import java.sql.*;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {

	/**
	 * Salva ou obtém o ID de um cliente. Se o cliente já existir (pelo CPF),
	 * retorna o ID existente. Caso contrário, salva um novo cliente e retorna o ID
	 * gerado.
	 */
	private int salvarOuObterClienteId(Connection connection, Cliente cliente) throws SQLException {
		// 1. Verifica se o cliente já existe pelo CPF
		String sqlSelect = "SELECT id FROM clientes WHERE cpf = ?";
		try (PreparedStatement stmtSelect = connection.prepareStatement(sqlSelect)) {
			stmtSelect.setString(1, cliente.getCpf());
			try (ResultSet rs = stmtSelect.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1); // Retorna o ID se já existir
				}
			}
		}

		// 2. Se não existir, salva o novo cliente
		String sqlInsert = "INSERT INTO clientes (nome, cpf) VALUES (?, ?)";
		try (PreparedStatement stmtInsert = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
			stmtInsert.setString(1, cliente.getNome());
			stmtInsert.setString(2, cliente.getCpf());
			stmtInsert.executeUpdate();

			try (ResultSet generatedKeys = stmtInsert.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				}
			}
		}
		throw new SQLException("Falha ao salvar cliente, nenhum ID obtido.");
	}

	/**
	 * Salva um novo pedido, incluindo o cliente e todos os seus itens, em uma única
	 * transação de banco de dados.
	 */
	public void salvar(Pedido pedido) {
		String sqlPedido = "INSERT INTO pedidos (funcionario_id, cliente_id, total) VALUES (?, ?, ?)";
		String sqlItem = "INSERT INTO pedido_itens (pedido_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
		Connection connection = null;

		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false); // Inicia a transação

			// 1. Salva o cliente e obtém o ID
			int clienteId = salvarOuObterClienteId(connection, pedido.getCliente());
			pedido.getCliente().setId(clienteId);

			// 2. Salva o Pedido
			try (PreparedStatement stmtPedido = connection.prepareStatement(sqlPedido,
					Statement.RETURN_GENERATED_KEYS)) {
				stmtPedido.setInt(1, pedido.getFuncionario().getId());
				stmtPedido.setInt(2, pedido.getCliente().getId()); // <-- Atribui o ID do cliente
				stmtPedido.setBigDecimal(3, pedido.getTotal());
				stmtPedido.executeUpdate();

				try (ResultSet generatedKeys = stmtPedido.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						pedido.setId(generatedKeys.getInt(1));
					}
				}
			}

			// 3. Salva os Itens do Pedido
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

	// Métodos para Relatórios
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