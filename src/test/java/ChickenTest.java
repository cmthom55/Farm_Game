import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for Chicken class.
 */
public class ChickenTest {

    /**
     * Tests the properties of a 
     * {@code Chicken} instance to ensure correct initialization.
     */
    @Test
    public void testChickenProperties() {
        Chicken chicken = new Chicken();

        assertEquals(10, chicken.getBuyPrice());
        assertEquals(15, chicken.getDaysLeftToLive());
        assertEquals(1, chicken.getDiseaseLevel());

        assertTrue(chicken.getProductProducer() instanceof EggProducer);
    }
}
