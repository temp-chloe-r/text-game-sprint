import org.junit.Before;
import org.junit.Test;
import textadv.GameState;
import static org.junit.Assert.*;

public class TestGameState {
    @Before
    public void setUp(){

    }

    @Test
    public void testGridSize(){
        GameState gs = new GameState(5);
        assertEquals(gs.gridSize, 5);
    }

    public void testWinMessage(){
        GameState gs = new GameState(5);
        gs.playerX = 0;
        gs.playerY = 0;
        gs.treasureX = 0;
        gs.treasureY = 0;
        String actualOutput = gs.play().getPrintedOutput(); // Call the wrapper method

        // Assert
        String expectedOutput = "Expected output here";
        assertEquals(expectedOutput, actualOutput);
    }

}
