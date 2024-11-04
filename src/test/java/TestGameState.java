import org.junit.Before;
import org.junit.Test;
import textadv.GameState;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;


import static org.junit.Assert.*;

public class TestGameState {
    @Before
    public void setUp(){

    }

    @Test
    public void testGridSize(){
        GameState gs = new GameState(5, false, null);
        assertEquals(gs.gridSize, 5);
    }

    @Test
    public void testPlayerPositionWithinGrid() {
        GameState gs = new GameState(5, false, null);
        assertTrue("Player X position should be within grid bounds", gs.playerX >= 0 && gs.playerX < 5);
        assertTrue("Player Y position should be within grid bounds", gs.playerY >= 0 && gs.playerY < 5);
    }

    @Test
    public void testTreasurePositionWithinGrid() {
        GameState gs = new GameState(5, false, null);
        assertTrue("Treasure position should be within grid bounds", gs.treasureX >= 0 && gs.treasureX < 5);
        assertTrue("Treasure position should be within grid bounds", gs.treasureY >= 0 && gs.treasureY < 5);
    }

    @Test
    public void testWinMessage() throws InterruptedException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("d\nr\n".getBytes());
        GameState gs = new GameState(5, true, inputStream);
        gs.playerX = 0;
        gs.playerY = 0;
        gs.treasureX = 1;
        gs.treasureY = 1;

        gs.play();
        assertTrue(gs.gameWon);
    }

}
