import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Cow class.
 */
public class CowTest {

    private Cow cow;
    private ProductProducer mockMilkProducer;

    /**
     * Set up the test environment.
     */
    @Before
    public void setUp() {
        mockMilkProducer = mock(MilkProducer.class);
        cow = new Cow();
        cow.setProductProducer(mockMilkProducer);
    }

    /**
     * Test the properties of the Cow class.
     */
    @Test
    public void testCowProperties() {
        assertEquals(40, cow.getBuyPrice());
        assertEquals(14, cow.getDaysLeftToLive());
        assertEquals(1, cow.getDiseaseLevel());
        assertTrue(cow.getProductProducer() instanceof MilkProducer);
    }
}
