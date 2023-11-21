import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FarmTest {

    /**
     * JUnit test class for the {@link Farm} class.
     */
    @Test
    public void testTryUpgrade() {
        Farmer mockFarmer = new Farmer();
        Farm farm = new Farm();

        assertEquals(0, farm.tryUpgrade(500));

        mockFarmer.setTotalIncome(1000);
        mockFarmer.setFarmerBuddies(10);

        assertEquals(2, farm.tryUpgrade(1000));
        assertEquals(0, farm.tryUpgrade(1000));

        mockFarmer.setTotalIncome(0);
        mockFarmer.setFarmerBuddies(10);

        assertEquals(0, farm.tryUpgrade(500));

        mockFarmer.setTotalIncome(0);
        mockFarmer.setFarmerBuddies(10);

        assertEquals(0, farm.tryUpgrade(750));

        mockFarmer.setTotalIncome(0);
        mockFarmer.setFarmerBuddies(10);

        assertEquals(0, farm.tryUpgrade(1000));

        mockFarmer.setTotalIncome(0);
        mockFarmer.setFarmerBuddies(10);

        assertTrue(3 == farm.tryUpgrade(3000));

        mockFarmer.setTotalIncome(3000);
        mockFarmer.setFarmerBuddies(10);

        assertEquals(4, farm.tryUpgrade(3000));
    }

    @Test
    public void testGetNumOfFarms() {
        Farmer mockFarmer = new Farmer();

        Farm farm = new Farm();

        assertEquals(1, farm.getNumOfFarms());

        mockFarmer.setTotalIncome(1000);
        mockFarmer.setFarmerBuddies(10);

        farm.tryUpgrade(1000);

        assertEquals(1, farm.getNumOfFarms());

        mockFarmer.setTotalIncome(3000);
        mockFarmer.setFarmerBuddies(10);

        farm.tryUpgrade(3000);

        mockFarmer.setTotalIncome(750);
        mockFarmer.setFarmerBuddies(10);

        farm.tryUpgrade(750);

        assertEquals(2, farm.getNumOfFarms());
    }

    @Test
    public void testGetMaxCapacity() {
        Farmer mockFarmer = new Farmer();

        Farm farm = new Farm();

        assertEquals(10, farm.getMaxCapacity());

        mockFarmer.setTotalIncome(1000);
        mockFarmer.setFarmerBuddies(10);

        farm.tryUpgrade(1000);

        assertEquals(20, farm.getMaxCapacity());
    }

    @Test
    public void testGetMaxAnimalCapacity() {
        Farmer mockFarmer = new Farmer();

        Farm farm = new Farm();

        assertEquals(20, farm.getMaxAnimalCapacity());

        mockFarmer.setTotalIncome(1000);
        mockFarmer.setFarmerBuddies(10);

        farm.tryUpgrade(1000);

        assertEquals(40, farm.getMaxAnimalCapacity());
    }

    @Test
    public void testGetMaxCropsCapacity() {
        Farmer mockFarmer = new Farmer();

        Farm farm = new Farm();

        assertEquals(50, farm.getMaxCropsCapacity());

        mockFarmer.setTotalIncome(1000);
        mockFarmer.setFarmerBuddies(10);

        farm.tryUpgrade(1000);

        assertEquals(100, farm.getMaxCropsCapacity());
    }

    @Test
    public void testGetLevel() {
        Farmer mockFarmer = new Farmer();

        Farm farm = new Farm();

        assertEquals(1, farm.getLevel());

        mockFarmer.setTotalIncome(1000);
        mockFarmer.setFarmerBuddies(10);

        farm.tryUpgrade(1000);

        assertEquals(2, farm.getLevel());
    }

    @Test
    public void testSetLevel() {
        Farmer mockFarmer = new Farmer();
        Farm farm = new Farm();

        farm.setLevel(3);

        assertEquals(3, farm.getLevel());
    }
}
