package view;

import javax.swing.*;
import java.awt.*;

public class TelaGradiente extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color cor1 = new Color(0, 153, 102);
        Color cor2 = new Color(0, 204, 153);
        GradientPaint gp = new GradientPaint(0, 0, cor1, 0, getHeight(), cor2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
