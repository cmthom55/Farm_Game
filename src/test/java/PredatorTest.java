import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test class for the {@link Predator} class.
 */
public class PredatorTest {

    @Test
    public void testUpdateHuntCycle_SuccessfulHunt() {
        Predator predator = new Predator("Lion", "Gazelle");

        boolean result = predator.updateHuntCycle();
        
        while (result != true) {
            result = predator.updateHuntCycle();
        }

        assertTrue(result);
    }

    @Test
    public void testUpdateHuntCycle_UnsuccessfulHunt() {
        Predator predator = new Predator("Tiger", "Zebra");

        boolean result = predator.updateHuntCycle();
        
        while (result != false) {
            result = predator.updateHuntCycle();
        }
        
        assertFalse(result);
    }

    @Test
    public void testGetName() {
        Predator predator = new Predator("Leopard", "Antelope");
        assertEquals("Leopard", predator.getName());
    }

    @Test
    public void testGetPrey() {
        Predator predator = new Predator("Cheetah", "Impala");
        assertEquals("Impala", predator.getPrey());
    }

    @Test
    public void testSetName() {
        Predator predator = new Predator("Jaguar", "Capybara");
        predator.setName("Black Panther");
        assertEquals("Black Panther", predator.getName());
    }

    @Test
    public void testSetPrey() {
        Predator predator = new Predator("Snow Leopard", "Marmot");
        predator.setPrey("Yak");
        assertEquals("Yak", predator.getPrey());
    }
}
