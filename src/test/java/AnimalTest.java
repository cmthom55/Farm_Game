import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Animal class.
 */
public class AnimalTest {

    private Animal animal;
    private ProductProducer mockProductProducer;

    /**
     * Sets up the test environment by creating a mock 
     * {@code ProductProducer} and an instance of {@code Animal}.
     */
    @Before
    public void setUp() {
        mockProductProducer = mock(ProductProducer.class);
        animal = new Animal(100, 5, 1, mockProductProducer);
    }

    /**
     * Tests the {@code updateDaysRemaining} method to ensure correct behavior.
     */
    @Test
    public void testUpdateDaysRemaining() {
        assertTrue(animal.updateDaysRemaining());
        assertEquals(4, animal.getDaysLeftToLive());

        animal.setSick();
        assertTrue(animal.updateDaysRemaining());
        assertEquals(1, animal.getDaysLeftToLive());

        assertFalse(animal.updateDaysRemaining());
        assertEquals(-2, animal.getDaysLeftToLive());
    }

    /**
     * Tests the {@code setSick} method to ensure correct sickness level setting.
     */
    @Test
    public void testSetSick() {
        animal.setSick();
        assertEquals(3, animal.getDiseaseLevel());
    }

    /**
     * Tests the {@code heal} method to ensure correct healing behavior.
     */
    @Test
    public void testHeal() {
        animal.setSick();
        animal.heal();
        assertEquals(1, animal.getDiseaseLevel());
    }

    /**
     * Tests the {@code produceProduct} method 
     * to ensure correct product production and selling behavior.
     */
    @Test
    public void testProduceProduct() {
        when(mockProductProducer.getProductQuantity()).thenReturn(5);

        animal.produceProduct();

        verify(mockProductProducer, times(1)).produceProduct();
        verify(mockProductProducer, times(1)).sellProduct();

        assertEquals(5, animal.getProductQuantity());
    }

    /**
     * Tests the {@code setProductProducer} method to ensure 
     * correct setting of a new product producer.
     */
    @Test
    public void testSetProductProducer() {
        ProductProducer newMockProductProducer = mock(ProductProducer.class);

        animal.setProductProducer(newMockProductProducer);

        assertEquals(newMockProductProducer, animal.getProductProducer());
    }
}
