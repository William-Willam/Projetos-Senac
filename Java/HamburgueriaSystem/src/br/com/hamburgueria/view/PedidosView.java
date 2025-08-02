package br.com.hamburgueria.view;

import br.com.hamburgueria.controller.PedidoController;
import br.com.hamburgueria.controller.ProdutoController;
import br.com.hamburgueria.model.Funcionario;
import br.com.hamburgueria.model.ItemPedido;
import br.com.hamburgueria.model.Pedido;
import br.com.hamburgueria.model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidosView extends JPanel {

    private Funcionario funcionarioLogado;
    private ProdutoController produtoController;
    private PedidoController pedidoController;

    // Componentes da interface
    private JTable tabelaProdutosDisponiveis;
    private DefaultTableModel produtosTableModel;
    
    private JTable tabelaItensPedido;
    private DefaultTableModel itensTableModel;
    
    private JLabel lblTotal;
    private JButton btnAdicionar, btnRemover, btnFinalizarPedido, btnCancelarPedido;
    private JSpinner spinnerQuantidade;

    private List<ItemPedido> itensAtuais;

    public PedidosView(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
        this.produtoController = new ProdutoController();
        this.pedidoController = new PedidoController();
        this.itensAtuais = new ArrayList<>();
        initComponents();
        carregarProdutosDisponiveis();
        atualizarTotal();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Painel Superior: Produtos Disponíveis ---
        JPanel produtosPanel = new JPanel(new BorderLayout());
        produtosPanel.setBorder(BorderFactory.createTitledBorder("Produtos Disponíveis"));
        
        String[] colunasProdutos = {"ID", "Nome", "Preço"};
        produtosTableModel = new DefaultTableModel(colunasProdutos, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaProdutosDisponiveis = new JTable(produtosTableModel);
        JScrollPane scrollProdutos = new JScrollPane(tabelaProdutosDisponiveis);
        produtosPanel.add(scrollProdutos, BorderLayout.CENTER);

        JPanel adicionarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        spinnerQuantidade = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        btnAdicionar = new JButton("Adicionar ao Pedido");
        adicionarPanel.add(new JLabel("Quantidade:"));
        adicionarPanel.add(spinnerQuantidade);
        adicionarPanel.add(btnAdicionar);
        produtosPanel.add(adicionarPanel, BorderLayout.SOUTH);

        this.add(produtosPanel, BorderLayout.WEST);

        // --- Painel Central: Itens do Pedido ---
        JPanel itensPanel = new JPanel(new BorderLayout());
        itensPanel.setBorder(BorderFactory.createTitledBorder("Itens do Pedido"));

        String[] colunasItens = {"ID Produto", "Produto", "Quantidade", "Subtotal"};
        itensTableModel = new DefaultTableModel(colunasItens, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaItensPedido = new JTable(itensTableModel);
        JScrollPane scrollItens = new JScrollPane(tabelaItensPedido);
        itensPanel.add(scrollItens, BorderLayout.CENTER);

        JPanel botoesItensPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnRemover = new JButton("Remover Item");
        botoesItensPanel.add(btnRemover);
        itensPanel.add(botoesItensPanel, BorderLayout.SOUTH);
        
        this.add(itensPanel, BorderLayout.CENTER);

        // --- Painel Inferior: Resumo e Ações ---
        JPanel resumoPanel = new JPanel(new BorderLayout());
        resumoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        lblTotal = new JLabel("Total: R$ 0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        resumoPanel.add(lblTotal, BorderLayout.EAST);
        
        JPanel acoesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnFinalizarPedido = new JButton("Finalizar Pedido");
        btnCancelarPedido = new JButton("Cancelar Pedido");
        acoesPanel.add(btnFinalizarPedido);
        acoesPanel.add(btnCancelarPedido);
        resumoPanel.add(acoesPanel, BorderLayout.WEST);

        this.add(resumoPanel, BorderLayout.SOUTH);

        setupListeners();
    }
    
    private void setupListeners() {
        btnAdicionar.addActionListener(e -> adicionarProdutoAoPedido());
        btnRemover.addActionListener(e -> removerItemDoPedido());
        btnFinalizarPedido.addActionListener(e -> finalizarPedido());
        btnCancelarPedido.addActionListener(e -> cancelarPedido());
    }

    private void carregarProdutosDisponiveis() {
        produtosTableModel.setRowCount(0);
        List<Produto> produtos = produtoController.listarTodosProdutos();
        for (Produto p : produtos) {
            produtosTableModel.addRow(new Object[]{p.getId(), p.getNome(), p.getPreco()});
        }
    }

    private void adicionarProdutoAoPedido() {
        int selectedRow = tabelaProdutosDisponiveis.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para adicionar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idProduto = (int) produtosTableModel.getValueAt(selectedRow, 0);
        String nomeProduto = (String) produtosTableModel.getValueAt(selectedRow, 1);
        BigDecimal preco = (BigDecimal) produtosTableModel.getValueAt(selectedRow, 2);
        int quantidade = (int) spinnerQuantidade.getValue();

        // Crie o objeto Produto para o ItemPedido
        Produto produto = new Produto(idProduto, nomeProduto, null, preco);
        
        // Crie o Item do Pedido
        ItemPedido novoItem = new ItemPedido(produto, quantidade, preco);

        // Verifique se o item já existe no pedido para atualizar a quantidade
        boolean itemExistente = false;
        for (ItemPedido item : itensAtuais) {
            if (item.getProduto().getId() == idProduto) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                itemExistente = true;
                break;
            }
        }
        
        if (!itemExistente) {
            itensAtuais.add(novoItem);
        }
        
        atualizarTabelaItens();
        atualizarTotal();
    }

    private void removerItemDoPedido() {
        int selectedRow = tabelaItensPedido.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um item para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        itensAtuais.remove(selectedRow);
        atualizarTabelaItens();
        atualizarTotal();
    }

    private void atualizarTabelaItens() {
        itensTableModel.setRowCount(0);
        for (ItemPedido item : itensAtuais) {
            itensTableModel.addRow(new Object[]{
                item.getProduto().getId(),
                item.getProduto().getNome(),
                item.getQuantidade(),
                item.getSubtotal()
            });
        }
    }
    
    private void atualizarTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itensAtuais) {
            total = total.add(item.getSubtotal());
        }
        lblTotal.setText("Total: R$ " + total.toString());
    }

    private void finalizarPedido() {
        if (itensAtuais.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O pedido não pode estar vazio.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itensAtuais) {
            total = total.add(item.getSubtotal());
        }

        Pedido novoPedido = new Pedido(funcionarioLogado, itensAtuais);
        novoPedido.setTotal(total);
        
        pedidoController.salvarPedido(novoPedido);

        JOptionPane.showMessageDialog(this, "Pedido finalizado com sucesso! Total: R$ " + total);
        limparPedido();
    }
    
    private void cancelarPedido() {
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar o pedido atual?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            limparPedido();
            JOptionPane.showMessageDialog(this, "Pedido cancelado.");
        }
    }
    
    private void limparPedido() {
        itensAtuais.clear();
        atualizarTabelaItens();
        atualizarTotal();
    }
}