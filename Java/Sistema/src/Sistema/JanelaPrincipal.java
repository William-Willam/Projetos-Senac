package Sistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame {

    private VeiculoManager manager = new VeiculoManager();
    private JTextArea areaListagem = new JTextArea();

    public JanelaPrincipal() {
        setTitle("Sistema de Veículos");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Cadastrar", criarPainelCadastro());
        abas.addTab("Listar Todos", criarPainelListagem(false));
        abas.addTab("Disponíveis", criarPainelListagem(true));
        abas.addTab("Excluir", criarPainelExclusao());

        add(abas);
    }

    private JPanel criarPainelCadastro() {
        JPanel painel = new JPanel(new GridLayout(9, 2));
        String[] tipos = {"Carro", "Moto", "Caminhão"};
        JComboBox<String> tipoBox = new JComboBox<>(tipos);
        JTextField marca = new JTextField();
        JTextField modelo = new JTextField();
        JTextField ano = new JTextField();
        JTextField preco = new JTextField();
        JCheckBox disponivel = new JCheckBox("Disponível");
        JTextField extra = new JTextField();
        JLabel labelExtra = new JLabel("");

        tipoBox.addActionListener(e -> {
            switch (tipoBox.getSelectedItem().toString()) {
                case "Carro" -> labelExtra.setText("Número de portas:");
                case "Moto" -> labelExtra.setText("Cilindradas:");
                case "Caminhão" -> labelExtra.setText("Capacidade de carga:");
            }
        });

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            try {
                String t = tipoBox.getSelectedItem().toString();
                int a = Integer.parseInt(ano.getText());
                double p = Double.parseDouble(preco.getText());
                boolean d = disponivel.isSelected();

                switch (t) {
                    case "Carro" -> manager.adicionar(new Carro(marca.getText(), modelo.getText(), a, p, d, Integer.parseInt(extra.getText())));
                    case "Moto" -> manager.adicionar(new Moto(marca.getText(), modelo.getText(), a, p, d, Integer.parseInt(extra.getText())));
                    case "Caminhão" -> manager.adicionar(new Caminhao(marca.getText(), modelo.getText(), a, p, d, Double.parseDouble(extra.getText())));
                }
                JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + ex.getMessage());
            }
        });

        painel.add(new JLabel("Tipo:")); painel.add(tipoBox);
        painel.add(new JLabel("Marca:")); painel.add(marca);
        painel.add(new JLabel("Modelo:")); painel.add(modelo);
        painel.add(new JLabel("Ano:")); painel.add(ano);
        painel.add(new JLabel("Preço:")); painel.add(preco);
        painel.add(labelExtra); painel.add(extra);
        painel.add(disponivel); painel.add(btnCadastrar);
        return painel;
    }

    private JScrollPane criarPainelListagem(boolean somenteDisponiveis) {
        areaListagem.setEditable(false);
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> {
            areaListagem.setText("");
            for (Veiculo v : somenteDisponiveis ? manager.listarDisponiveis() : manager.listarTodos()) {
                areaListagem.append(
                    v.getClass().getSimpleName() + " - " + v.getMarca() + " " + v.getModelo() +
                    " | Ano: " + v.getAno() +
                    " | Preço: R$" + v.getPreco() +
                    " | Seguro: R$" + String.format("%.2f", v.calcularSeguro()) +
                    " | Disponível: " + v.disponivel + "\n"
                );
            }
        });

        JPanel painel = new JPanel(new BorderLayout());
        painel.add(new JScrollPane(areaListagem), BorderLayout.CENTER);
        painel.add(btnAtualizar, BorderLayout.SOUTH);
        return new JScrollPane(painel);
    }

    private JPanel criarPainelExclusao() {
        JPanel painel = new JPanel(new BorderLayout());
        JTextField campoIndice = new JTextField();
        JButton btnExcluir = new JButton("Excluir por índice");

        btnExcluir.addActionListener(e -> {
            try {
                int index = Integer.parseInt(campoIndice.getText());
                manager.remover(index);
                JOptionPane.showMessageDialog(this, "Removido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        painel.add(new JLabel("Índice:"), BorderLayout.NORTH);
        painel.add(campoIndice, BorderLayout.CENTER);
        painel.add(btnExcluir, BorderLayout.SOUTH);
        return painel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaPrincipal().setVisible(true));
    }
}
