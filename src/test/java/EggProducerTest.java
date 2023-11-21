import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * JUnit test class for the {@link EggProducer} class.
 */
public class EggProducerTest {

    /**
     * Tests the properties of the {@link EggProducer} instance.
     */
    @Test
    public void testEggProducerProperties() {
        EggProducer eggProducer = new EggProducer();
        assertEquals(0, eggProducer.getEggsProduced());
    }

    /**
     * Tests egg production and selling functionality of the {@link EggProducer}.
     */
    @Test
    public void testEggProductionAndSelling() {
        EggProducer eggProducer = new EggProducer();

        eggProducer.produceProduct();
        eggProducer.produceProduct();
        assertEquals(2, eggProducer.getEggsProduced());

        int amountMade = eggProducer.sellProduct();

        assertEquals(300, amountMade);
        assertEquals(0, eggProducer.getEggsProduced());
    }

    /**
     * Tests the sold message returned by the {@link EggProducer}.
     */
    @Test
    public void testSoldMessage() {
        EggProducer eggProducer = new EggProducer();

        assertEquals("All eggs sold, they are also golden hooray!", eggProducer.soldMessage());
    }

    /**
     * Tests getting the product quantity produced by the {@link EggProducer}.
     */
    @Test
    public void testGetProductQuantity() {
        EggProducer eggProducer = new EggProducer();

        eggProducer.produceProduct();
        eggProducer.produceProduct();

        assertEquals(2, eggProducer.getProductQuantity());
    }
}
