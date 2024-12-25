package JFrameMovementRandomMap;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        RandomMap randomMap = new RandomMap(); // creates instance of the randomMap class
        randomMap.generateMap(); // calls generateMap();
        JFrame frame = new JFrame(); // creates instance of JFrame
        keyListener keyListener = new keyListener(randomMap); // creates instance of the key listener class
        frame.add(randomMap); // adds the randomMap class to the JFrame
        randomMap.setBackground(Color.green); // sets the bg color to green
        frame.setSize(1015,638); // sets the height and width of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sets what happens when you click the x
        frame.addKeyListener(keyListener); // adds the keylistener to the frame
        frame.setVisible(true); // makes the frame actually visible
    }
}
