package JFrameMovement;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

       JFrame frame = new JFrame();
       Box box = new Box();
       keyListener keyListener = new keyListener(box);
       frame.add(box);
       box.setBackground(Color.green);
       frame.setSize(600,600);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.addKeyListener(keyListener);
       frame.setVisible(true);
    }
}
