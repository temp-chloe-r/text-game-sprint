import org.junit.Before;
import org.junit.Test;
import textadv.Monster;

import static org.junit.Assert.*;

public class TestMonster {

    private static final int GRID_SIZE = 10;
    private Monster monster;

    @Before
    public void setUp() {
        monster = new Monster("AWS", "Hehehe... You can't escape me!", GRID_SIZE);
    }

    @Test
    public void testMonsterInitialization() {
        // Test that monster name and greeting are set correctly
        assertEquals("Monster name should be 'AWS'", "AWS", monster.getName());
        assertEquals("Monster greeting should be 'Hehehe... You can't escape me!'", "Hehehe... You can't escape me!", monster.getGreeting());
    }

    @Test
    public void testMonsterPositionWithinGrid() {
        // Test that monster position is within the grid boundaries
        assertTrue("Monster X position should be within grid bounds", monster.getX() >= 0 && monster.getX() < GRID_SIZE);
        assertTrue("Monster Y position should be within grid bounds", monster.getY() >= 0 && monster.getY() < GRID_SIZE);
        System.out.println("Monster X position: " + monster.getX());
    }

    @Test
    public void testIsAtLocation_whenPlayerIsAtMonsterLocation() {
        // Directly testing isAtLocation, assuming we know monster's coordinates
        int monsterX = monster.getX();
        int monsterY = monster.getY();

        assertTrue("isAtLocation should return true when player is at monster's location", monster.isAtLocation(monsterX, monsterY));
    }

    @Test
    public void testIsAtLocation_whenPlayerIsNotAtMonsterLocation() {
        // Check that isAtLocation returns false when player is not at monster's coordinates
        int playerX = (monster.getX() + 1) % GRID_SIZE; // Move player to a different position
        int playerY = (monster.getY() + 1) % GRID_SIZE;

        assertFalse("isAtLocation should return false when player is not at monster's location", monster.isAtLocation(playerX, playerY));
    }
}
