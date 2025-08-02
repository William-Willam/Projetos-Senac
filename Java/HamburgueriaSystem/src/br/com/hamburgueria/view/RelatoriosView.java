package br.com.hamburgueria.view;

import br.com.hamburgueria.controller.PedidoController;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class RelatoriosView extends JPanel {

    private PedidoController pedidoController;

    private JLabel lblTotalVendas, lblNumeroPedidos;

    public RelatoriosView() {
        this.pedidoController = new PedidoController();
        initComponents();
        carregarDados();
    }

    private void initComponents() {
        this.setLayout(new GridLayout(4, 1, 10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel lblTitle = new JLabel("Relatórios de Vendas");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblTitle);

        JPanel panelTotalVendas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTotalLabel = new JLabel("Total de Vendas: ");
        lblTotalLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTotalVendas = new JLabel("Carregando...");
        lblTotalVendas.setFont(new Font("Arial", Font.BOLD, 18));
        panelTotalVendas.add(lblTotalLabel);
        panelTotalVendas.add(lblTotalVendas);
        this.add(panelTotalVendas);

        JPanel panelNumeroPedidos = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblPedidosLabel = new JLabel("Número de Pedidos: ");
        lblPedidosLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNumeroPedidos = new JLabel("Carregando...");
        lblNumeroPedidos.setFont(new Font("Arial", Font.BOLD, 18));
        panelNumeroPedidos.add(lblPedidosLabel);
        panelNumeroPedidos.add(lblNumeroPedidos);
        this.add(panelNumeroPedidos);
    }
    
    private void carregarDados() {
        BigDecimal totalVendas = pedidoController.calcularTotalVendas();
        int numeroPedidos = pedidoController.contarPedidos();

        lblTotalVendas.setText("R$ " + (totalVendas != null ? totalVendas.toString() : "0.00"));
        lblNumeroPedidos.setText(String.valueOf(numeroPedidos));
    }
}