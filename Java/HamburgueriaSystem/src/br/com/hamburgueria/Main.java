package br.com.hamburgueria;

import br.com.hamburgueria.view.LoginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Inicializa o FlatLaf antes de criar a interface
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}