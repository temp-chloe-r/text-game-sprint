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
        GameState gs = new GameState(5, false);
        assertEquals(gs.gridSize, 5);
    }

    @Test
    public void testWinMessage() throws InterruptedException {
        GameState gs = new GameState(5, true);
        gs.playerX = 0;
        gs.playerY = 0;
        gs.treasureX = 1;
        gs.treasureY = 1;
        gs.play();

        System.setIn(new ByteArrayInputStream("d\nl\n".getBytes()));

        assertEquals(gs.gameWon, true);
    }

}
