package textadv;

// Import required Java libraries
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameState {
    // Initialisations for key program operation
    public final int gridSize;
    public int playerX, playerY;
    public int treasureX, treasureY;
    private final ArrayList<Monster> monsters = new ArrayList<>();
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private boolean testMode = false;
    public boolean gameWon = false;

    // GameState Constructor
    public GameState(int gridSize, boolean testMode) {
        this.gridSize = gridSize;
        if (gridSize < 5) gridSize = 5;
        this.testMode = testMode;
        initializeGame();
    }

    private void initializeGame() {
        // Place player at random location
        playerX = random.nextInt(gridSize);
        playerY = random.nextInt(gridSize);

        // Place treasure at random location
        do {
            treasureX = random.nextInt(gridSize);
            treasureY = random.nextInt(gridSize);
        } while (treasureX == playerX && treasureY == playerY);

        // Add monsters at random locations
        if (!testMode) addMonsters();

        // Print game welcome text to terminal
        System.out.println("Welcome to the Treasure Hunt Game!");
        System.out.println("You are on a " + gridSize + "x" + gridSize + " grid. Find the treasure to win!");
    }

    // Add monsters to the game
    private void addMonsters() {
        // Collection of monster types
        Monster[] monsterTypes = {
                new Monster("Oracle", "Fee fi fo fum... I smell a merger!", gridSize),
                new Monster("JP Morgan", "I see a business opportunity...", gridSize),
                new Monster("AWS", "Hehehe... You can't escape me!", gridSize),
                new Monster("IBM", "I smell money...", gridSize)
        };

        // Create an appropriate amount of monsters to reflect the size of grid
        for (int i = 0; i < gridSize-1; i++) {
            // Make a new monster object instance with random monster type
            Monster monster = monsterTypes[random.nextInt(monsterTypes.length)];
            // Ensure that monster is not initialised on the same square as either the player or treasure (don't care about other monsters)
            int counter = 0;
            while((monster.getX() == playerX && monster.getY() == playerY) || (monster.getX() == treasureX && monster.getY() == treasureY)) {
                monster.resetLocation();
                counter++;
                if (counter > 10) break; // Failsafe
            }
            if (counter <= 10) monsters.add(monster);
        }

    }
    // Main Game Loop
    public void play() {
        while (true) {
            // Display game information to player
            printDistanceToTreasure();
            System.out.println("Enter move (up, down, left, right): ");
            if (!scanner.hasNextLine()) {
                continue; // Skip if no input
            }
            String move = scanner.nextLine().toLowerCase();
            // "Move" the player based on their input (can also accept traditional text adventure n/s/e/w)
            switch (move) {
                case "up": case "u": case "n": {
                    if (playerY > 0) {
                        playerY--;
                        System.out.println("Moving up...");
                    } else System.out.println("Can't move up...");
                    break;
                }
                case "down": case "d": case "s": {
                    if (playerY < gridSize - 1) {
                        playerY++;
                        System.out.println("Moving down...");
                    } else System.out.println("Can't move down...");
                    break;
                }
                case "left": case "l": case "w": {
                    if (playerX > 0) {
                        playerX--;
                        System.out.println("Moving left...");
                    } else System.out.println("Can't move left...");
                    break;
                }
                case "right": case "r": case "e": {
                    if (playerX < gridSize - 1) {
                        playerX++;
                        System.out.println("Moving right...");
                    } else System.out.println("Can't move right...");
                    break;
                }
                default: System.out.println("Invalid move. Try again."); continue;
            }
            // Check for win state (Treasure is encountered)
            if (playerX == treasureX && playerY == treasureY) {
                gameWon = true;
                System.out.println("Congratulations! You've safely found the treasure and won the game!");
                break;
            }
            // Check for loss state (Monster is encountered)
            for (Monster monster : monsters) {
                if (monster.isAtLocation(playerX, playerY)) {
                    System.out.println(monster.getGreeting());
                    System.out.println("Oh no! You've been caught by the " + monster.getName() + "! Game Over.");
                    return;
                }
            }
        }
    }

    // Print statement for win state
    private void printDistanceToTreasure() {
        int distance = Math.abs(playerX - treasureX) + Math.abs(playerY - treasureY);
        System.out.println("You are " + distance + " steps away from the treasure.");
    }
}
