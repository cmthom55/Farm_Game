import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for the {@link SheepTest} class.
 */
public class SheepTest {

    private Sheep sheep;
    private ProductProducer mockWoolProducer;

    /**
     * Sets up sheep and mockWoolProducer test objects for test cases.
     */
    @Before
    public void setUp() {
        mockWoolProducer = mock(WoolProducer.class);

        sheep = new Sheep();
        sheep.setProductProducer(mockWoolProducer);
    }

    @Test
    public void testSheepProperties() {
        assertEquals(20, sheep.getBuyPrice());
        assertEquals(14, sheep.getDaysLeftToLive());
        assertEquals(1, sheep.getDiseaseLevel());
        assertTrue(sheep.getProductProducer() instanceof WoolProducer);
    }
}
