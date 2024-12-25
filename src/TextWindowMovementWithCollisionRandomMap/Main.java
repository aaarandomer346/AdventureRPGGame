package TextWindowMovementWithCollisionRandomMap;

public class Main {
    public static void main(String[] args) {
        RandomMap randomMap = new RandomMap();
        randomMap.generateMap();
        new Player();
    }
}
