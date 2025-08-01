package view;

import javax.swing.*;
import dao.FuncionarioDAO;
import java.awt.*;

public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Label e campo de usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblUsuario, gbc);

        JTextField txtUsuario = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtUsuario, gbc);

        // Label e campo de senha
        JLabel lblSenha = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblSenha, gbc);

        JPasswordField txtSenha = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(txtSenha, gbc);

        // Botão de login
        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBackground(new Color(0, 123, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        // Botão de cadastro
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(0, 123, 255));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        gbc.gridy = 3;
        panel.add(btnCadastrar, gbc);

        // Adiciona o painel ao frame
        add(panel, BorderLayout.CENTER);

        // Ações dos botões
        btnLogin.addActionListener(e -> {
            FuncionarioDAO dao = new FuncionarioDAO();
            if (dao.autenticar(txtUsuario.getText(), new String(txtSenha.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                // abrir tela de admin ou balconista (ainda vamos criar)
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
            }
        });

        btnCadastrar.addActionListener(e -> {
            new TelaCadastro().setVisible(true);
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
