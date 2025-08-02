package br.com.hamburgueria.view;

import br.com.hamburgueria.controller.FuncionarioController;
import br.com.hamburgueria.model.Funcionario;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private FuncionarioController funcionarioController;

    public LoginView() {
        this.funcionarioController = new FuncionarioController();
        initComponents();
        setupFrame();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.decode("#F5F5F5"));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel lblTitle = new JLabel("Login do Sistema");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBackground(mainPanel.getBackground());
        
        JLabel lblUsuario = new JLabel("Usuário:");
        txtUsuario = new JTextField(15);
        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField(15);
        
        inputPanel.add(lblUsuario);
        inputPanel.add(txtUsuario);
        inputPanel.add(lblSenha);
        inputPanel.add(txtSenha);

        btnLogin = new JButton("Entrar");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setBackground(Color.decode("#4CAF50"));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adiciona um listener para o botão de login
        btnLogin.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());
            
            Funcionario funcionario = funcionarioController.autenticar(usuario, senha);
            
            if (funcionario != null) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                if (funcionario.isAdmin()) {
                    new AdminDashboard(funcionario).setVisible(true);
                } else {
                	new FuncionarioDashboard(funcionario).setVisible(true);
                }
                this.dispose(); // Fecha a tela de login
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        mainPanel.add(lblTitle);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(btnLogin);

        this.add(mainPanel);
    }

    private void setupFrame() {
        this.setTitle("Login - Sistema Hamburgueria");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centraliza a janela
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}