package JavaSwing.view;

import javax.swing.*;

public class MinhaTela extends JFrame {

	// criar um metodo publico
	public MinhaTela() {
		// criar a tela 
		setTitle("Minha Tela em Swing");
		setSize(400, 300);
		setLocationRelativeTo(null);// centraliza a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fecha o frame, ou seja, a tela
		setLayout(null);// layout manual (posições fixas)
		
		// componente
		JLabel texto = new JLabel("Bem-vindo");
		texto.setBounds(160,20,100,30);// x, y, largura, altura
		add(texto);// aplicar na tela o bem vindo
		
		// compoente botao
		JButton botao = new JButton("Clique aqui");
		botao.setBounds(130, 50, 120, 30);// x, y, largura, altura
		add(botao);
	}
	
	
	// a parte mais importante do arquivo
	public static void main(String[] args) {
		// invocar a tela ao compilar
		SwingUtilities.invokeLater(() -> new MinhaTela().setVisible(true));
	}

}
