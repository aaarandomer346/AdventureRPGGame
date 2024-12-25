package JFrameMovementRandomMap;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        RandomMap randomMap = new RandomMap();
        randomMap.generateMap();
        JFrame frame = new JFrame();
        keyListener keyListener = new keyListener(randomMap);
        frame.add(randomMap);
        randomMap.setBackground(Color.green);
        frame.setSize(1015,638);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(keyListener);
        frame.setVisible(true);
    }
}
