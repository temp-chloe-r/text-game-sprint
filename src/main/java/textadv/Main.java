package textadv;

import java.util.Scanner;

/* Grid-based text adventure game
* The player can enter directions to move around the game board, with the aim of reaching the "treasure".
* If the player encounters any monsters, they will die, and the game will be over. */

public class Main {
    public static void main(String[] args) {
        // Get grid size from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the desired game grid size (i.e. 10 - 10x10):");
        int gridSize=-1;
        while (gridSize < 5) {
            // Make sure grid size is large enough for game setup
            gridSize = sc.nextInt();
            if (gridSize < 5) System.out.println("Grid size too small. Please enter a grid size of at least 5!");
        }
        GameState game = new GameState(gridSize, false);
        game.play(); // Start the game loop
    }
}