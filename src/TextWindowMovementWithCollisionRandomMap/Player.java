package TextWindowMovementWithCollisionRandomMap;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    RandomMap randomMap = new RandomMap();
    int wood = 0;
    String[] inv = {"Wood: " + wood};
    Player() {
        while (true) {
            String moveWhere = scanner.nextLine();
            move(moveWhere);
            randomMap.printMap();
        }
    }

    void move(String moveWhere) {
        int x = 0;
        int y = 0;

        switch (moveWhere) {
            case "w" -> y = -1;
            case "a" -> x = -1;
            case "s" -> y = 1;
            case "d" -> x = 1;
            case "inv" -> {
                for (String s : inv) {
                    System.out.println(s);
                }
            }
        }
        int playerX = randomMap.playerX;
        int playerY = randomMap.playerY;
        if (randomMap.playerX >= 50 || randomMap.playerX <= -1 ||
                randomMap.playerY >= 15 || randomMap.playerY <= -1) {
            return;
        }
        else if (randomMap.hasTree(playerX + x, playerY + y)){
            System.out.println("Do you want to break the tree?");
            wood++;
            inv[0] = "Wood: " + wood;
            String treeBreak = scanner.nextLine();
            if (treeBreak.equals("n")) {
                return;
            }
        }
        randomMap.updatePlayerPosition(playerX + x, playerY + y);
    }
}
