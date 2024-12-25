package JFrameMovement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener {
    private final Box box;

    public keyListener(Box box) {
        this.box = box;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("right");
            box.moveBox(40, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("left");
            box.moveBox(-40, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("right");
            box.moveBox(0, -40);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("left");
            box.moveBox(0, 40);
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
