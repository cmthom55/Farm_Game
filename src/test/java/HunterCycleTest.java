import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for the {@link HunterCycle} class.
 */
public class HunterCycleTest {

    private HunterCycle hunterCycle;
    private Predator predator;
    private Predator predator2;
    private Predator predator3;
    private Predator predator4;

    /**
     * Sets up test predators and hunterCycle.
     */
    @Before
    public void setUp() {
        hunterCycle = new HunterCycle();
        predator = new Predator("Tiger", "Cow");
        predator2 = new Predator("Mole", "Wheat");
        predator3 = new Predator("Wolf", "Sheep"); 
        predator4 = new Predator("Fox", "Chicken");
    }

    @Test
    public void testHunterCycle() {
        assertTrue(hunterCycle.getAnimalsToEat().isEmpty());
        assertTrue(hunterCycle.getWheatCropsToEat().isEmpty());

        ArrayList<Animal> animalsOnFarm = new ArrayList<>();
        animalsOnFarm.add(new Cow());
        animalsOnFarm.add(new Sheep());
        animalsOnFarm.add(new Chicken());
        hunterCycle.setAnimalsToEat(animalsOnFarm);

        ArrayList<WheatCrop> wheatCropsOnFarm = new ArrayList<>();
        wheatCropsOnFarm.add(new WheatCrop());
        hunterCycle.setWheatCropsToEat(wheatCropsOnFarm);

        hunterCycle.addObserver(predator);
        hunterCycle.addObserver(predator2);
        hunterCycle.addObserver(predator3);
        hunterCycle.addObserver(predator4);

        while (hunterCycle.getAnimalsToEat().size() != 0 
                || !hunterCycle.getWheatCropsToEat().isEmpty()) {
            hunterCycle.setTimeToHunt(true); 
        }
        
        assertEquals(0, hunterCycle.getAnimalsToEat().size());
        assertTrue(hunterCycle.getWheatCropsToEat().isEmpty());
    }

    @Test
    public void testPredator() {
        assertEquals("Tiger", predator.getName());
        assertEquals("Cow", predator.getPrey());
    }
}
