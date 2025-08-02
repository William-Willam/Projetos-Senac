package br.com.hamburgueria.view;

import br.com.hamburgueria.controller.FuncionarioController;
import br.com.hamburgueria.model.Funcionario;

import javax.swing.*;
import java.awt.*;

public class AtualizarSenhaView extends JPanel {

    private Funcionario funcionarioLogado;
    private FuncionarioController funcionarioController;

    private JPasswordField txtSenhaAtual, txtNovaSenha, txtConfirmarSenha;
    private JButton btnAtualizar;

    public AtualizarSenhaView(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
        this.funcionarioController = new FuncionarioController();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Atualizar Senha");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        this.add(lblTitle, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        this.add(new JLabel("Senha Atual:"), gbc);
        txtSenhaAtual = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        this.add(txtSenhaAtual, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        this.add(new JLabel("Nova Senha:"), gbc);
        txtNovaSenha = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 2;
        this.add(txtNovaSenha, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        this.add(new JLabel("Confirmar Senha:"), gbc);
        txtConfirmarSenha = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 3;
        this.add(txtConfirmarSenha, gbc);

        btnAtualizar = new JButton("Atualizar Senha");
        btnAtualizar.setBackground(Color.decode("#3498DB"));
        btnAtualizar.setForeground(Color.WHITE);
        btnAtualizar.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        this.add(btnAtualizar, gbc);

        setupListeners();
    }

    private void setupListeners() {
        btnAtualizar.addActionListener(e -> atualizarSenha());
    }

    private void atualizarSenha() {
        String senhaAtual = new String(txtSenhaAtual.getPassword());
        String novaSenha = new String(txtNovaSenha.getPassword());
        String confirmarSenha = new String(txtConfirmarSenha.getPassword());

        if (!senhaAtual.equals(funcionarioLogado.getSenha())) {
            JOptionPane.showMessageDialog(this, "A senha atual está incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (novaSenha.isEmpty() || novaSenha.length() < 6) {
            JOptionPane.showMessageDialog(this, "A nova senha deve ter no mínimo 6 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!novaSenha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(this, "A nova senha e a confirmação não coincidem.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Atualiza o objeto do funcionário
        funcionarioLogado.setSenha(novaSenha);
        // Chama o controller para persistir a mudança no banco
        funcionarioController.atualizarFuncionario(funcionarioLogado);

        JOptionPane.showMessageDialog(this, "Senha atualizada com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        txtSenhaAtual.setText("");
        txtNovaSenha.setText("");
        txtConfirmarSenha.setText("");
    }
}