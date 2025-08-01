package view;

import javax.swing.*;
import model.Funcionario;
import dao.FuncionarioDAO;
import java.awt.*;

public class TelaCadastro extends JFrame {
    public TelaCadastro() {
        setTitle("Cadastro de Funcionário");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Label e campo de nome
        JLabel lblNome = new JLabel("Nome:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblNome, gbc);

        JTextField txtNome = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtNome, gbc);

        // Label e campo de usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblUsuario, gbc);

        JTextField txtUsuario = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtUsuario, gbc);

        // Label e campo de senha
        JLabel lblSenha = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblSenha, gbc);

        JPasswordField txtSenha = new JPasswordField(20);
        gbc.gridx = 1;
        panel.add(txtSenha, gbc);

        // Label e combo box de tipo
        JLabel lblTipo = new JLabel("Tipo:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblTipo, gbc);

        String[] tipos = { "balconista", "admin" };
        JComboBox<String> cbTipo = new JComboBox<>(tipos);
        gbc.gridx = 1;
        panel.add(cbTipo, gbc);

        // Botão de salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(new Color(0, 123, 255));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(btnSalvar, gbc);

        // Adiciona o painel ao frame
        add(panel, BorderLayout.CENTER);

        // Ação do botão salvar
        btnSalvar.addActionListener(e -> {
            Funcionario f = new Funcionario();
            f.setNome(txtNome.getText());
            f.setUsuario(txtUsuario.getText());
            f.setSenha(new String(txtSenha.getPassword())); 
            f.setTipo(cbTipo.getSelectedItem().toString());

            if (new FuncionarioDAO().cadastrar(f)) {
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar.");
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastro().setVisible(true));
    }
}
