package br.com.hamburgueria.view;

import br.com.hamburgueria.controller.FuncionarioController;
import br.com.hamburgueria.model.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FuncionariosView extends JPanel {

    private FuncionarioController funcionarioController;

    // Componentes para o formulário
    private JTextField txtId, txtNome, txtUsuario;
    private JPasswordField txtSenha;
    private JCheckBox cbAdmin;
    private JButton btnSalvar, btnLimpar, btnExcluir, btnAtualizar;

    // Componentes para a tabela
    private JTable tabelaFuncionarios;
    private DefaultTableModel tableModel;

    public FuncionariosView() {
        this.funcionarioController = new FuncionarioController();
        initComponents();
        carregarTabelaFuncionarios();
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
        txtId.setEnabled(false);
        txtNome = new JTextField(20);
        txtUsuario = new JTextField(15);
        txtSenha = new JPasswordField(15);
        cbAdmin = new JCheckBox("Administrador");

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Usuário:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        formPanel.add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        formPanel.add(txtSenha, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Acesso:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        formPanel.add(cbAdmin, gbc);
        
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

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 3;
        formPanel.add(buttonPanel, gbc);

        this.add(formPanel, BorderLayout.NORTH);

        // --- Tabela de Funcionários (Centro) ---
        String[] colunas = {"ID", "Nome", "Usuário", "Admin"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Torna a tabela não editável
            }
        };
        tabelaFuncionarios = new JTable(tableModel);
        tabelaFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(tabelaFuncionarios), BorderLayout.CENTER);

        // --- Adiciona os listeners de eventos ---
        setupListeners();
    }
    
    private void setupListeners() {
        btnSalvar.addActionListener(e -> salvarFuncionario());
        btnAtualizar.addActionListener(e -> atualizarFuncionario());
        btnExcluir.addActionListener(e -> excluirFuncionario());
        btnLimpar.addActionListener(e -> limparFormulario());
        tabelaFuncionarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabelaFuncionarios.getSelectedRow() != -1) {
                preencherFormularioComDadosDaTabela();
            }
        });
    }

    private void carregarTabelaFuncionarios() {
        tableModel.setRowCount(0);
        List<Funcionario> funcionarios = funcionarioController.listarTodosFuncionarios();
        for (Funcionario f : funcionarios) {
            tableModel.addRow(new Object[]{f.getId(), f.getNome(), f.getUsuario(), f.isAdmin()});
        }
    }
    
    private void salvarFuncionario() {
        String nome = txtNome.getText();
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());
        boolean isAdmin = cbAdmin.isSelected();
        
        if (nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Funcionario novoFuncionario = new Funcionario(nome, usuario, senha, isAdmin);
        funcionarioController.salvarFuncionario(novoFuncionario);
        
        JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso!");
        limparFormulario();
        carregarTabelaFuncionarios();
    }
    
    private void atualizarFuncionario() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());
        boolean isAdmin = cbAdmin.isSelected();

        Funcionario funcionarioAtualizado = new Funcionario(id, nome, usuario, senha, isAdmin);
        funcionarioController.atualizarFuncionario(funcionarioAtualizado);
        
        JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!");
        limparFormulario();
        carregarTabelaFuncionarios();
    }
    
    private void excluirFuncionario() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este funcionário?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(txtId.getText());
            funcionarioController.excluirFuncionario(id);
            JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
            limparFormulario();
            carregarTabelaFuncionarios();
        }
    }
    
    private void limparFormulario() {
        txtId.setText("");
        txtNome.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
        cbAdmin.setSelected(false);
        tabelaFuncionarios.clearSelection();
    }
    
    private void preencherFormularioComDadosDaTabela() {
        int selectedRow = tabelaFuncionarios.getSelectedRow();
        if (selectedRow >= 0) {
            txtId.setText(tabelaFuncionarios.getValueAt(selectedRow, 0).toString());
            txtNome.setText(tabelaFuncionarios.getValueAt(selectedRow, 1).toString());
            txtUsuario.setText(tabelaFuncionarios.getValueAt(selectedRow, 2).toString());
            cbAdmin.setSelected((boolean) tabelaFuncionarios.getValueAt(selectedRow, 3));
            txtSenha.setText(""); // Por segurança, a senha não é preenchida
        }
    }
}