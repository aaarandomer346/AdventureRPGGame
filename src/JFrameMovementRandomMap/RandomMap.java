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
                    chanceOfGrass = 80;     // make sures the map cant be only trees
                }
                if (chanceOfGrass < 80) {
                    chanceOfGrass += 10;    // make sures the map cant be only trees
                }
                if (arrays.get(i).get(j).equals("T")) {
                    chanceOfGrass -= 10;    // if the current tile is a tree the next tile is most likely also a tree
                }
                if (i - 1 != -1 && j + 1 != 50 && arrays.get(i - 1).get(j + 1).equals("T")) {
                    chanceOfGrass -= 10; // if the tree 1 above and 1 right is a tree then the next tile has a higher chance of being a tree
                }
            }
        }
        updatePlayerPosition(playerXInFrame, playerYInFrame); // updates player position
    }

    public boolean hasTree(int x, int y) {
        return arrays.get(y).get(x).equals("T");    // checks if where the player is going there is a tree
    }


    void updatePlayerPosition(int newX, int newY) {
        arrays.get(playerYInFrame).set(playerXInFrame, "#");    // Clear old player position

        playerXInFrame = newX;  // Update new player position
        playerYInFrame = newY;  // Update new player position

        arrays.get(playerYInFrame).set(playerXInFrame, "@");    // set current tile to a player tile
    }

    @Override
    public void paintComponent(Graphics g) {
        int tileSize = 20; // sets the size of a tile
        int paintY = 0; // sets the Y axis of where objects are going to be spawned
        Rectangle2D[][] objects = new Rectangle2D[30][50]; // creates an array of an array to hold all the objects in the map
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // makes a new graphics2d object, will be used to paint in the objects in the map

        for (int i = 0; i < arrays.size(); i++) { // for each y-level
            int paintX = 0; // set the X axis of where objects will be spawned
            objects[i] = new Rectangle2D[50]; // adds a new array to the other array that will hold the rectangles
            for (int j = 0; j < arrays.get(i).size(); j++) { // for each tile
                if (arrays.get(i).get(j).equals("T")) { // if the tile is a tree
                    objects[i][j] = new Rectangle2D.Double(paintX, paintY, tileSize, tileSize); // paint a rectangle
                    g2.setColor(Color.black); // set the graphics2d object to black
                    g2.fill(objects[i][j]); // set the object to black
                }
                paintX += tileSize; // adds the tilesize to the paintX to make sure the next tile is right next to the current tile
            }
            paintY += tileSize; // adds the tilesize to the paintY so objects spawn correctly bellow
        }

        Rectangle2D player = new Rectangle2D.Double(playerXInFrame, playerYInFrame, tileSize, tileSize); // makes the player rectangle
        g2.setColor(Color.red); // sets the graphics2d to red
        g2.fill(player); // paints the player red
    }
    public void moveBox(int dx, int dy, int gdx, int gdy) { // responsible for player movement
        if (checkEdgeOfMap(dx, dy) && !hasTree(playerXInGrid + gdx, playerYInGrid + gdy)) { // checks if there is a tree where the player is going to move or if the player is going to move out-of bounds
            playerXInFrame += dx; // makes the player move in the direction they want to go, only for the JFrame
            playerYInFrame += dy; // makes the player move in the direction they want to go, only for the JFrame
            playerXInGrid += gdx; // makes the player move in the direction they want to go, only for the grid with all the strings
            playerYInGrid += gdy; // makes the player move in the direction they want to go, only for the grid with all the strings
            repaint(); // repaints everything
        }
    }

    public boolean checkEdgeOfMap(int x, int y) { // checks if the player is going to be out of the map
        return playerXInFrame +x < 1000 && playerXInFrame +x > -1 &&
                playerYInFrame +y < 600 && playerYInFrame +y > -1;
    }
}
