package JFrameMovementRandomMap;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class RandomMap extends JPanel {

    int playerXInFrame = 0;
    int playerYInFrame = 0;
    int playerXInGrid = 0;
    int playerYInGrid = 0;
    static ArrayList<ArrayList<String>> arrays = new ArrayList<>(); // holds the positions of grass, trees, etc.
    double chanceOfGrass = 85; // the chance of grass spawning
    Random randomTile = new Random(); // random generator

    void generateMap() {
        arrays.clear();
        for (int i = 0; i < 30; i++) {
            arrays.add(new ArrayList<>()); // makes 15 arrayLists in the arrayList of arraylists, acts as rows
        }
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 50; j++) {
                int tile = randomTile.nextInt(100); // gets random number
                // if the random number is below or equal to the chance of grass spawning add grass
                if (tile <= chanceOfGrass) {
                    arrays.get(i).add("#");
                }
                // else add a tree
                else {
                    arrays.get(i).add("T");
                }
                if (chanceOfGrass < 20) {
                    chanceOfGrass = 80;
                }
                if (chanceOfGrass < 80) {
                    chanceOfGrass += 10;
                }
                if (arrays.get(i).get(j).equals("T")) {
                    chanceOfGrass -= 10;
                }
                if (i - 1 != -1 && j + 1 != 50 && arrays.get(i - 1).get(j + 1).equals("T")) {
                    chanceOfGrass -= 10;
                }
            }
        }
        updatePlayerPosition(playerXInFrame, playerYInFrame);
    }

    public boolean hasTree(int x, int y) {
        return arrays.get(y).get(x).equals("T");
    }

    void updatePlayerPosition(int newX, int newY) {
        // Clear old player position
        arrays.get(playerYInFrame).set(playerXInFrame, "#");

        // Update new player position
        playerXInFrame = newX;
        playerYInFrame = newY;
        arrays.get(playerYInFrame).set(playerXInFrame, "@");
    }

    @Override
    public void paintComponent(Graphics g) {
        int tileSize = 20;
        int paintY = 0;
        Rectangle2D[][] objects = new Rectangle2D[30][50];
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < arrays.size(); i++) {
            int paintX = 0;
            objects[i] = new Rectangle2D[50];
            for (int j = 0; j < arrays.get(i).size(); j++) {
                if (arrays.get(i).get(j).equals("T")) {
                    objects[i][j] = new Rectangle2D.Double(paintX, paintY, tileSize, tileSize);
                    g2.setColor(Color.black);
                    g2.fill(objects[i][j]);
                }
                paintX += tileSize;
            }
            paintY += tileSize;
        }

        Rectangle2D player = new Rectangle2D.Double(playerXInFrame, playerYInFrame, tileSize, tileSize);
        g2.setColor(Color.red);
        g2.fill(player);
    }
    public void moveBox(int dx, int dy, int gdx, int gdy) {
        if (checkEdgeOfMap(dx, dy) && !hasTree(playerXInGrid + gdx, playerYInGrid + gdy)) {
            playerXInFrame += dx;
            playerYInFrame += dy;
            playerXInGrid += gdx;
            playerYInGrid += gdy;
            repaint();
        }
    }

    public boolean checkEdgeOfMap(int x, int y) {
        return playerXInFrame +x < 1000 && playerXInFrame +x > -1 &&
                playerYInFrame +y < 600 && playerYInFrame +y > -1;
    }
}
