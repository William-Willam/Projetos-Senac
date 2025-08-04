package br.com.hamburgueria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

	private int id;
	private Funcionario funcionario;
	private Cliente cliente;
	private LocalDateTime dataPedido;
	private BigDecimal total;
	private List<ItemPedido> itens;

	// Construtor padrão
	public Pedido() {
	}

	// Construtor completo
	public Pedido(Funcionario funcionario, Cliente cliente, List<ItemPedido> itens) {
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.itens = itens;
		this.dataPedido = LocalDateTime.now();
		this.total = BigDecimal.ZERO;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}