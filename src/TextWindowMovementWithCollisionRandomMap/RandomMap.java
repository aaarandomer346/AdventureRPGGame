package TextWindowMovementWithCollisionRandomMap;

import java.util.ArrayList;
import java.util.Random;

public class RandomMap {

    int playerX = 3;
    int playerY = 3;
    static ArrayList<ArrayList<String>> arrays = new ArrayList<>(); // holds the positions of grass, trees, etc.
    double chanceOfGrass = 85; // the chance of grass spawning
    Random randomTile = new Random(); // random generator

    void generateMap() {
        arrays.clear();
        for (int i = 0; i < 15; i++) {
            arrays.add(new ArrayList<>()); // makes 15 arrayLists in the arrayList of arraylists, acts as rows
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 50; j++) {
                int tile = randomTile.nextInt(100); // gets random number
                // if the random number is below or equal to the chance of grass spawning add grass
                if (tile <= chanceOfGrass) {
                    arrays.get(i).add("🌱");
                }
                // else add a tree
                else {
                    arrays.get(i).add("🎄");
                }
                if (chanceOfGrass < 20) {
                    chanceOfGrass = 80;
                }
                if (chanceOfGrass < 80) {
                    chanceOfGrass += 10;
                }
                if (arrays.get(i).get(j).equals("🎄")) {
                    chanceOfGrass -= 10;
                }
                if (i - 1 != -1 && j + 1 != 50 && arrays.get(i - 1).get(j + 1).equals("🎄")) {
                    chanceOfGrass -= 10;
                }
            }
        }
        updatePlayerPosition(playerX, playerY);
        printMap();
    }

    void printMap() {
        for (ArrayList<String> array : arrays) {
            for (String s : array) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public boolean hasTree(int x, int y) {
        return arrays.get(y).get(x).equals("🎄");
    }

    void updatePlayerPosition(int newX, int newY) {
        // Clear old player position
        arrays.get(playerY).set(playerX, "🌱");

        // Update new player position
        playerX = newX;
        playerY = newY;
        arrays.get(playerY).set(playerX, "🧍");
    }
}
