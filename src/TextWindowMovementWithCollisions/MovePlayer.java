package TextWindowMovementWithCollisions;

import java.util.Scanner;

public class MovePlayer {
    Scanner scanner = new Scanner(System.in);
    Map generateInfiniteMap = new Map();
    MovePlayer() {
        while (true) {
            System.out.println("Where do you want to move?");
            String moveWhere = scanner.nextLine();
            move(moveWhere);
            generateInfiniteMap.printWorld();
        }
    }

    void move(String moveWhere) {
        int x = 0;
        int y = 0;

        switch (moveWhere) {
            case "w" -> {
                y = 1;
            }
            case "a" -> {
                x = -1;
            }
            case "s" -> {
                y = -1;
            }
            case "d" -> {
                x = 1;
            }
        }

        int[] playerXY = generateInfiniteMap.playerXY;
        if (generateInfiniteMap.hasTree(playerXY[0] + x, playerXY[1] + y)){
            return;
        }
        generateInfiniteMap.updatePlayerPosition(playerXY[0] + x, playerXY[1] + y);
    }
}
