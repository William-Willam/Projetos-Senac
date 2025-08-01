package view;

import javax.swing.*;
import java.awt.*;
import dao.FuncionarioDAO;
import model.Funcionario;

public class TelaPrincipal extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel painelFormulario;

    public TelaPrincipal() {
        setTitle("Hamburgueria - Login/Cadastro");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(false);

        JPanel container = new JPanel(new GridLayout(1, 2));

        // Painel com gradiente verde (lado esquerdo)
        JPanel painelEsquerda = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 153, 102), getWidth(), getHeight(), new Color(0, 102, 51));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        painelEsquerda.setLayout(new BoxLayout(painelEsquerda, BoxLayout.Y_AXIS));
        painelEsquerda.setBorder(BorderFactory.createEmptyBorder(60, 30, 60, 30));

        JLabel lblBemVindo = new JLabel("Bem-vindo de volta!");
        lblBemVindo.setForeground(Color.WHITE);
        lblBemVindo.setFont(new Font("SansSerif", Font.BOLD, 24));
        lblBemVindo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblMensagem = new JLabel("<html><div style='text-align: center;'>Para continuar conectado conosco,<br>entre com suas informações.</div></html>");
        lblMensagem.setForeground(Color.WHITE);
        lblMensagem.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblMensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMensagem.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JButton btnTrocar = criarBotaoVerde("Cadastrar-se");
        btnTrocar.setBackground(Color.WHITE);
        btnTrocar.setForeground(new Color(0, 153, 102));
        btnTrocar.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 102), 2));

        painelEsquerda.add(lblBemVindo);
        painelEsquerda.add(lblMensagem);
        painelEsquerda.add(Box.createVerticalGlue());
        painelEsquerda.add(btnTrocar);
        painelEsquerda.add(Box.createRigidArea(new Dimension(0, 30)));

        // Painel da direita com formulários
        painelFormulario = new JPanel(cardLayout);
        painelFormulario.setBackground(Color.WHITE);
        painelFormulario.add(criarPainelLogin(), "login");
        painelFormulario.add(criarPainelCadastro(), "cadastro");

        cardLayout.show(painelFormulario, "login");

        btnTrocar.addActionListener(e -> {
            cardLayout.next(painelFormulario);
            btnTrocar.setText(btnTrocar.getText().equals("Cadastrar-se") ? "Entrar" : "Cadastrar-se");
        });

        container.add(painelEsquerda);
        container.add(painelFormulario);
        add(container);
    }

    private JPanel criarPainelLogin() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titulo = new JLabel("Entrar");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titulo, gbc);

        JLabel lblUsuario = new JLabel("Usuário:");
        JTextField txtUsuario = new JTextField(15);
        estilizarCampo(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(15);
        estilizarCampo(txtSenha);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblUsuario, gbc);
        gbc.gridx = 1; panel.add(txtUsuario, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblSenha, gbc);
        gbc.gridx = 1; panel.add(txtSenha, gbc);

        JButton btnEntrar = criarBotaoVerde("Entrar");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(btnEntrar, gbc);

        btnEntrar.addActionListener(e -> {
            FuncionarioDAO dao = new FuncionarioDAO();
            boolean ok = dao.autenticar(txtUsuario.getText(), new String(txtSenha.getPassword()));
            if (ok) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                // abrir próxima tela aqui...
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.");
            }
        });

        return panel;
    }

    private JPanel criarPainelCadastro() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titulo = new JLabel("Criar conta");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(titulo, gbc);

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(15);
        estilizarCampo(txtNome);

        JLabel lblUsuario = new JLabel("Usuário:");
        JTextField txtUsuario = new JTextField(15);
        estilizarCampo(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        JPasswordField txtSenha = new JPasswordField(15);
        estilizarCampo(txtSenha);

        JLabel lblTipo = new JLabel("Tipo:");
        JComboBox<String> cbTipo = new JComboBox<>(new String[]{"balconista", "admin"});
        estilizarCampo(cbTipo);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblNome, gbc);
        gbc.gridx = 1; panel.add(txtNome, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblUsuario, gbc);
        gbc.gridx = 1; panel.add(txtUsuario, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblSenha, gbc);
        gbc.gridx = 1; panel.add(txtSenha, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(lblTipo, gbc);
        gbc.gridx = 1; panel.add(cbTipo, gbc);

        JButton btnCadastrar = criarBotaoVerde("Cadastrar-se");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(btnCadastrar, gbc);

        btnCadastrar.addActionListener(e -> {
            Funcionario f = new Funcionario();
            f.setNome(txtNome.getText());
            f.setUsuario(txtUsuario.getText());
            f.setSenha(new String(txtSenha.getPassword()));
            f.setTipo(cbTipo.getSelectedItem().toString());

            if (new FuncionarioDAO().cadastrar(f)) {
                JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
                cardLayout.show(painelFormulario, "login");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar funcionário.");
            }
        });

        return panel;
    }

    // Estilo para botões verdes arredondados
    private JButton criarBotaoVerde(String texto) {
        JButton botao = new JButton(texto);
        botao.setBackground(new Color(0, 153, 102));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setFont(new Font("SansSerif", Font.BOLD, 14));
        botao.setPreferredSize(new Dimension(150, 40));
        botao.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 51), 1));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return botao;
    }

    // Estilo para campos de texto e combo
    private void estilizarCampo(JComponent campo) {
        campo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        campo.setFont(new Font("SansSerif", Font.PLAIN, 14));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
