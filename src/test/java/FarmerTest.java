import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for the {@link Farmer} class.
 */
public class FarmerTest {

    private Farmer farmer;

    @Before
    public void setUp() {
        farmer = new Farmer();
    }

    /**
     * Test case for the {@link Farmer#buyResources()} method.
     * Checks if the farmer correctly buys resources based on their income.
     */
    @Test
    public void testBuyResources() {
        farmer.setTotalIncome(500);

        farmer.buyResources();

        assertEquals(0, farmer.getAnimalsOnFarm().size());
        assertEquals(0, farmer.getWheatCropsOnFarm().size());
        assertTrue(0.0 == farmer.getTotalIncome());

        assertEquals(1, farmer.getFarmerBuddies());

        farmer.setTotalIncome(400);
        farmer.buyResources();
        assertEquals(1, farmer.getFarmerBuddies());
        
        farmer.setTotalIncome(1000);
        farmer.setFarmerBuddies(10);
        
        farmer.buyResources();
        assertTrue(0.0 == farmer.getTotalIncome());
        
        farmer.setTotalIncome(3000);
        farmer.getFarm().setLevel(2);
        farmer.setFarmerBuddies(10);
        farmer.buyResources();
        assertTrue(0.0 == farmer.getTotalIncome());
        
        farmer.setTotalIncome(1000);
        farmer.getFarm().setLevel(1);
        farmer.setFarmerBuddies(10);
        farmer.buyResources();
        assertTrue(0.0 == farmer.getTotalIncome());
        
        farmer.getFarm().setLevel(1);
        
        farmer.setTotalIncome(40);
        farmer.buyResources();
        assertTrue(0.0 == farmer.getTotalIncome());
        
        farmer.setTotalIncome(20);
        farmer.buyResources();
        assertTrue(0.0 == farmer.getTotalIncome());
        
        farmer.setTotalIncome(15);
        farmer.buyResources();
        assertTrue(0.0 == farmer.getTotalIncome());
        
        farmer.setTotalIncome(10);
        farmer.buyResources();
        assertTrue(0.0 == farmer.getTotalIncome());            
    }

    /**
     * Test case for the {@link Farmer#performDailyActivities()} method.
     * Basic test to check if the method runs without errors.
     */
    @Test
    public void testPerformDailyActivities() {
        farmer.performDailyActivities();
    }

    /**
     * Test case for the {@link Farmer#calculateIncome()} method.
     * Basic test to check if the method runs without errors.
     */
    @Test
    public void testCalculateIncome() {
        double income = farmer.calculateIncome();
        assertEquals(0, income, 0);
    }
}
