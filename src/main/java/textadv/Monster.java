package textadv;

import java.util.Random;

public class Monster {
    private final String name;
    private final String greeting;
    private final int x, y;

    public Monster(String name, String greeting, int gridSize, int playerx, int playery) {
        Random random = new Random();
        this.name = name;
        this.greeting = greeting;
        this.x = random.nextInt(gridSize);
        this.y = random.nextInt(gridSize);
        // Ensure that monster is not initialised at the same location as the player

    }

    public String getName() {
        return name;
    }

    public String getGreeting() {
        return greeting;
    }

    public boolean isAtLocation(int playerX, int playerY) {
        return playerX == x && playerY == y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
