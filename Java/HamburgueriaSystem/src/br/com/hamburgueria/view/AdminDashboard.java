package br.com.hamburgueria.view;

import br.com.hamburgueria.model.Funcionario;
import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    private Funcionario admin;
    private JPanel contentPanel;
    private JButton btnRelatorios, btnProdutos, btnFuncionarios, btnSair;

    public AdminDashboard(Funcionario admin) {
        this.admin = admin;
        initComponents();
        setupFrame();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        // --- Painel da Barra Lateral (Menu) ---
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(Color.decode("#2C3E50"));
        sidebarPanel.setPreferredSize(new Dimension(200, getHeight()));
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel lblWelcome = new JLabel("Olá, " + admin.getNome());
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));
        lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        sidebarPanel.add(lblWelcome);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        btnRelatorios = createSidebarButton("Relatórios");
        btnProdutos = createSidebarButton("Produtos");
        btnFuncionarios = createSidebarButton("Funcionários");
        btnSair = createSidebarButton("Sair");

        sidebarPanel.add(btnRelatorios);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebarPanel.add(btnProdutos);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebarPanel.add(btnFuncionarios);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        sidebarPanel.add(btnSair);

        // --- Painel de Conteúdo Principal ---
        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());
        contentPanel.setBackground(Color.decode("#ECF0F1"));
        
        // Adiciona painéis placeholders para cada funcionalidade
        contentPanel.add(new RelatoriosView(), "RELATORIOS");
        contentPanel.add(new ProdutosView(), "PRODUTOS");
        contentPanel.add(new FuncionariosView(), "FUNCIONARIOS");

        // --- Adiciona os painéis à janela principal ---
        this.add(sidebarPanel, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);

        // --- Adiciona a lógica de troca de painéis (SPA) ---
        btnRelatorios.addActionListener(e -> showPanel("RELATORIOS"));
        btnProdutos.addActionListener(e -> showPanel("PRODUTOS"));
        btnFuncionarios.addActionListener(e -> showPanel("FUNCIONARIOS"));
        btnSair.addActionListener(e -> {
            this.dispose(); // Fecha o dashboard
            new LoginView().setVisible(true); // Abre a tela de login novamente
        });
    }

    private void setupFrame() {
        this.setTitle("Dashboard do Administrador");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button.setBackground(Color.decode("#34495E"));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        return button;
    }

    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) (contentPanel.getLayout());
        cl.show(contentPanel, panelName);
    }
}