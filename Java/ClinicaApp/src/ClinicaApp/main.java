package ClinicaApp;

import View.TelaPaciente;

public class main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TelaPaciente().setVisible(true);
        });
    }
}
