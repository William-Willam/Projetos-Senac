package JavaSwing.view;

// import duas bibliotecas para tela
import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {

	public Tela() {
		// criar a tela
		setTitle("Minha Tela em Swing - Recomendada, mais flexivel");
		setSize(400, 300);
		setLocationRelativeTo(null);// centraliza a janela
		
		// Usa o BorderLayout como layout principal da tela
		setLayout(new BorderLayout());
		
		// Cria um painel para colocar o rótulo
		JPanel painelTopo = new JPanel();
		
		// Usa o FlowLayout para centralizar os componentes dentro do painel
		painelTopo.setLayout(new FlowLayout(FlowLayout.CENTER));
		
        // Adiciona o rótulo ao painel
        JLabel label = new JLabel("Bem-vindo!");
        painelTopo.add(label);
        
     // Adiciona o painel à região superior (NORTH) da tela
        add(painelTopo, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		// invocar a tela ao compilar
		new Tela().setVisible(true);
	}

}
