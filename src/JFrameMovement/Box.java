package JFrameMovement;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Box extends JPanel {
    double x = 0, y = 0;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paint");
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rec = new Rectangle2D.Double(x, y, 20, 20);
        g2.fill(rec);
    }
    public void moveBox(int dx, int dy) {
        System.out.println("move");
        x += dx;
        y += dy;
        repaint();
    }
}
