package br.com.hamburgueria.view;

import br.com.hamburgueria.controller.ProdutoController;
import br.com.hamburgueria.model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class ProdutosView extends JPanel {

    private ProdutoController produtoController;

    // Componentes para o formulário
    private JTextField txtId, txtNome, txtPreco;
    private JTextArea txtDescricao;
    private JButton btnSalvar, btnLimpar, btnExcluir, btnAtualizar;

    // Componentes para a tabela
    private JTable tabelaProdutos;
    private DefaultTableModel tableModel;

    public ProdutosView() {
        this.produtoController = new ProdutoController();
        initComponents();
        carregarTabelaProdutos();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Painel de Formulário (Norte) ---
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtId = new JTextField(10);
        txtId.setEnabled(false); // ID não deve ser editável
        txtNome = new JTextField(20);
        txtPreco = new JTextField(10);
        txtDescricao = new JTextArea(3, 20);
        JScrollPane scrollDescricao = new JScrollPane(txtDescricao);
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(txtId, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Preço:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(txtPreco, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2;
        formPanel.add(scrollDescricao, gbc);
        
        // Botões do formulário
        JPanel buttonPanel = new JPanel();
        btnSalvar = new JButton("Salvar");
        btnAtualizar = new JButton("Atualizar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");
        buttonPanel.add(btnSalvar);
        buttonPanel.add(btnAtualizar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnLimpar);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 3;
        formPanel.add(buttonPanel, gbc);

        this.add(formPanel, BorderLayout.NORTH);

        // --- Tabela de Produtos (Centro) ---
        String[] colunas = {"ID", "Nome", "Descrição", "Preço"};
        tableModel = new DefaultTableModel(colunas, 0);
        tabelaProdutos = new JTable(tableModel);
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(tabelaProdutos), BorderLayout.CENTER);

        // --- Adiciona os listeners de eventos ---
        setupListeners();
    }
    
    private void setupListeners() {
        // Ação do botão Salvar
        btnSalvar.addActionListener(e -> salvarProduto());

        // Ação do botão Atualizar
        btnAtualizar.addActionListener(e -> atualizarProduto());

        // Ação do botão Excluir
        btnExcluir.addActionListener(e -> excluirProduto());

        // Ação do botão Limpar
        btnLimpar.addActionListener(e -> limparFormulario());

        // Ação de seleção da tabela
        tabelaProdutos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabelaProdutos.getSelectedRow() != -1) {
                preencherFormularioComDadosDaTabela();
            }
        });
    }

    private void carregarTabelaProdutos() {
        tableModel.setRowCount(0); // Limpa a tabela
        List<Produto> produtos = produtoController.listarTodosProdutos();
        for (Produto p : produtos) {
            tableModel.addRow(new Object[]{p.getId(), p.getNome(), p.getDescricao(), p.getPreco()});
        }
    }
    
    private void salvarProduto() {
        try {
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();
            BigDecimal preco = new BigDecimal(txtPreco.getText());
            
            Produto novoProduto = new Produto(nome, descricao, preco);
            produtoController.salvarProduto(novoProduto);
            
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            limparFormulario();
            carregarTabelaProdutos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Use um formato numérico.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void atualizarProduto() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();
            BigDecimal preco = new BigDecimal(txtPreco.getText());
            
            Produto produtoAtualizado = new Produto(id, nome, descricao, preco);
            produtoController.atualizarProduto(produtoAtualizado);
            
            JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
            limparFormulario();
            carregarTabelaProdutos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Use um formato numérico.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void excluirProduto() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este produto?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(txtId.getText());
            produtoController.excluirProduto(id);
            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
            limparFormulario();
            carregarTabelaProdutos();
        }
    }
    
    private void limparFormulario() {
        txtId.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        txtDescricao.setText("");
        tabelaProdutos.clearSelection();
    }
    
    private void preencherFormularioComDadosDaTabela() {
        int selectedRow = tabelaProdutos.getSelectedRow();
        if (selectedRow >= 0) {
            txtId.setText(tabelaProdutos.getValueAt(selectedRow, 0).toString());
            txtNome.setText(tabelaProdutos.getValueAt(selectedRow, 1).toString());
            txtDescricao.setText(tabelaProdutos.getValueAt(selectedRow, 2).toString());
            txtPreco.setText(tabelaProdutos.getValueAt(selectedRow, 3).toString());
        }
    }
}