package textadv;

import java.util.Random;

public class Monster {
    private final String name;
    private final String greeting;
    private int x, y;
    private final int gridSize;
    private Random random = new Random();

    // Monster constructor
    public Monster(String name, String greeting, int gridSize) {
        this.name = name;
        this.greeting = greeting;
        this.gridSize = gridSize;
        this.x = random.nextInt(gridSize);
        this.y = random.nextInt(gridSize);
    }

    // Change monster location (used when initialising monsters in GameState)
    public void resetLocation() {
        this.x = random.nextInt(gridSize);
        this.y = random.nextInt(gridSize);
    }

    /* VARIOUS ACCESSORS */
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
