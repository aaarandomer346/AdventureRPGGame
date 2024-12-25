package TextWindowMovementWithCollisions;

public class Map {

    int[] playerXY = {4, 2};

    String[] row0 = {"#","#","#","#","T","#","#","#","#"};
    String[] row1 = {"#","#","#","#","#","#","#","#","#"};
    String[] row2 = {"#","#","T","#","@","#","T","#","#"};
    String[] row3 = {"#","#","#","#","#","#","#","#","#"};
    String[] row4 = {"#","#","#","#","T","#","#","#","#"};
    String[][] rows = {row0, row1, row2, row3, row4};

    public boolean hasTree(int x, int y) {
        return rows[y][x].equals("T");
    }

    public void printWorld() {
        for (String[] row : rows) {
            for (int j = 0; j < row0.length; j++) {
                System.out.print(row[j]);
            }
            System.out.println();
        }
    }

    void updatePlayerPosition(int newX, int newY) {
        // Clear old player position
        rows[playerXY[1]][playerXY[0]] = "#";

        // Update new player position
        playerXY[0] = newX;
        playerXY[1] = newY;
        rows[playerXY[1]][playerXY[0]] = "@";
    }
}
