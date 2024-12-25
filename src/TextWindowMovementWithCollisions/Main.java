package TextWindowMovementWithCollisions;

public class Main {
    public static void main(String[] args) {
        Map generateInfiniteMap = new Map();
        generateInfiniteMap.printWorld();
        new MovePlayer();
    }
}
