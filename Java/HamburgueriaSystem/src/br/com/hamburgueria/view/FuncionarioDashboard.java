package br.com.hamburgueria.view;

import br.com.hamburgueria.model.Funcionario;
import javax.swing.*;
import java.awt.*;

public class FuncionarioDashboard extends JFrame {

	private Funcionario funcionario;
	private JPanel contentPanel;
	private JButton btnFazerPedido, btnAtualizarSenha, btnSair;

	public FuncionarioDashboard(Funcionario funcionario) {
		this.funcionario = funcionario;
		initComponents();
		setupFrame();
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());

		// --- Painel do Menu Horizontal (Norte) ---
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.decode("#34495E"));
		menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));

		btnFazerPedido = createMenuButton("Fazer Pedido");
		btnAtualizarSenha = createMenuButton("Atualizar Senha");
		btnSair = createMenuButton("Sair");

		menuPanel.add(btnFazerPedido);
		menuPanel.add(btnAtualizarSenha);
		menuPanel.add(Box.createHorizontalStrut(20)); // Espaço
		menuPanel.add(btnSair);

		// --- Painel de Conteúdo Principal ---
		contentPanel = new JPanel();
		contentPanel.setLayout(new CardLayout());

		// Telas a serem exibidas
		contentPanel.add(new PedidosView(funcionario), "FAZER_PEDIDO");
		contentPanel.add(new AtualizarSenhaView(funcionario), "ATUALIZAR_SENHA");

		this.add(menuPanel, BorderLayout.NORTH);
		this.add(contentPanel, BorderLayout.CENTER);

		// --- Adiciona a lógica de troca de painéis (SPA) ---
		btnFazerPedido.addActionListener(e -> showPanel("FAZER_PEDIDO"));
		btnAtualizarSenha.addActionListener(e -> showPanel("ATUALIZAR_SENHA"));
		btnSair.addActionListener(e -> {
			this.dispose();
			new LoginView().setVisible(true);
		});

		// Mostra a tela de Fazer Pedido por padrão
		showPanel("FAZER_PEDIDO");
	}

	private void setupFrame() {
		this.setTitle("Dashboard do Funcionário");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	private JButton createMenuButton(String text) {
		JButton button = new JButton(text);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.decode("#34495E"));
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		return button;
	}

	private void showPanel(String panelName) {
		CardLayout cl = (CardLayout) (contentPanel.getLayout());
		cl.show(contentPanel, panelName);
	}
}