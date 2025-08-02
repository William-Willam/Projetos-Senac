// PedidoController.java
package br.com.hamburgueria.controller;

import java.math.BigDecimal;

import br.com.hamburgueria.dao.PedidoDAO;
import br.com.hamburgueria.model.Pedido;

public class PedidoController {

    private PedidoDAO pedidoDAO;

    public PedidoController() {
        this.pedidoDAO = new PedidoDAO();
    }

    public void salvarPedido(Pedido pedido) {
        pedidoDAO.salvar(pedido);
    }
    
    public BigDecimal calcularTotalVendas() {
        return pedidoDAO.calcularTotalVendas();
    }

    public int contarPedidos() {
        return pedidoDAO.contarPedidos();
    }
}