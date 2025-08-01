package View;

import DAO.PacienteDAO;
import Model.Paciente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaPaciente extends JFrame {
    private JTextField nomeField, idadeField, cpfField;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JButton salvarButton, editarButton, excluirButton;
    private int pacienteSelecionadoId = -1;

    public TelaPaciente() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Gerenciamento de Pacientes");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Novo Paciente"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        nomeField = new JTextField(20);
        formPanel.add(nomeField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Idade:"), gbc);
        gbc.gridx = 1;
        idadeField = new JTextField(20);
        formPanel.add(idadeField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("CPF:"), gbc);
        gbc.gridx = 1;
        cpfField = new JTextField(20);
        formPanel.add(cpfField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(e -> salvarPaciente());
        buttonPanel.add(salvarButton);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(buttonPanel, gbc);
        mainPanel.add(formPanel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Pacientes Cadastrados"));
        modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Idade", "CPF"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        tablePanel.add(scroll, BorderLayout.CENTER);

        JPanel tableButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        editarButton = new JButton("Editar");
        editarButton.setEnabled(false);
        excluirButton = new JButton("Excluir");
        excluirButton.setEnabled(false);

        editarButton.addActionListener(e -> editarPaciente());
        excluirButton.addActionListener(e -> excluirPaciente());

        tabela.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tabela.getSelectedRow();
            boolean selected = selectedRow != -1;
            editarButton.setEnabled(selected);
            excluirButton.setEnabled(selected);

            if (selected) {
                pacienteSelecionadoId = (int) modelo.getValueAt(selectedRow, 0);
                nomeField.setText((String) modelo.getValueAt(selectedRow, 1));
                idadeField.setText(String.valueOf(modelo.getValueAt(selectedRow, 2)));
                cpfField.setText((String) modelo.getValueAt(selectedRow, 3));
            }
        });

        tableButtonPanel.add(editarButton);
        tableButtonPanel.add(excluirButton);
        tablePanel.add(tableButtonPanel, BorderLayout.SOUTH);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        listarPacientes();
    }

    private void salvarPaciente() {
        String nome = nomeField.getText().trim();
        String idadeStr = idadeField.getText().trim();
        String cpf = cpfField.getText().trim();

        if (nome.isEmpty() || idadeStr.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idade = Integer.parseInt(idadeStr);
            Paciente paciente = new Paciente(nome, idade, cpf);
            new PacienteDAO().salvar(paciente);
            listarPacientes();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Paciente salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida. Digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarPaciente() {
        if (pacienteSelecionadoId == -1) return;

        String nome = nomeField.getText().trim();
        String idadeStr = idadeField.getText().trim();
        String cpf = cpfField.getText().trim();

        if (nome.isEmpty() || idadeStr.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idade = Integer.parseInt(idadeStr);
            Paciente p = new Paciente(pacienteSelecionadoId, nome, idade, cpf);
            new PacienteDAO().editar(p);
            listarPacientes();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            pacienteSelecionadoId = -1;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Idade inválida. Digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirPaciente() {
        if (pacienteSelecionadoId == -1) return;

        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este paciente?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            new PacienteDAO().excluir(pacienteSelecionadoId);
            listarPacientes();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Paciente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            pacienteSelecionadoId = -1;
        }
    }

    private void listarPacientes() {
        modelo.setRowCount(0);
        List<Paciente> pacientes = new PacienteDAO().listarTodos();
        for (Paciente p : pacientes) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getIdade(), p.getCpf()});
        }
    }

    private void limparCampos() {
        nomeField.setText("");
        idadeField.setText("");
        cpfField.setText("");
        nomeField.requestFocus();
        tabela.clearSelection();
        editarButton.setEnabled(false);
        excluirButton.setEnabled(false);
        pacienteSelecionadoId = -1;
    }
}
