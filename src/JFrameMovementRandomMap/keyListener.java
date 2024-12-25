package JFrameMovementRandomMap;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener {
    // listens for key inputs not that hard to understand tbh
    private final RandomMap randomMap;

    public keyListener(RandomMap randomMap) {
        this.randomMap = randomMap;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            randomMap.moveBox(20, 0, 1, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            randomMap.moveBox(-20, 0, -1, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            randomMap.moveBox(0, -20, 0, -1);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            randomMap.moveBox(0, 20, 0, 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }
}
