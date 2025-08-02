package br.com.hamburgueria.model;

import java.math.BigDecimal;

public class ItemPedido {

    private int pedidoId;
    private Produto produto;
    private int quantidade;
    private BigDecimal precoUnitario;

    // Construtor padrão
    public ItemPedido() {
    }

    // Construtor completo
    public ItemPedido(Produto produto, int quantidade, BigDecimal precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    
    // Getters e Setters
    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    // Método auxiliar para calcular o subtotal do item
    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }
}