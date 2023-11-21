import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * JUnit test class for the {@link MilkProducer} class.
 */
public class MilkProducerTest {

    @Test
    public void testMilkProducerProperties() {
        MilkProducer milkProducer = new MilkProducer();

        assertEquals(0, milkProducer.getMilkProduced());
    }

    @Test
    public void testMilkProductionAndSelling() {
        MilkProducer milkProducer = new MilkProducer();

        milkProducer.produceProduct();
        milkProducer.produceProduct();
        assertEquals(10, milkProducer.getMilkProduced());

        int amountMade = milkProducer.sellProduct();

        assertEquals(500, amountMade);
        assertEquals(0, milkProducer.getMilkProduced());
    }

    @Test
    public void testSoldMessage() {
        MilkProducer milkProducer = new MilkProducer();
        assertEquals("All milk sold!", milkProducer.soldMessage());
    }

    @Test
    public void testGetProductQuantity() {
        MilkProducer milkProducer = new MilkProducer();

        milkProducer.produceProduct();
        milkProducer.produceProduct();

        assertEquals(10, milkProducer.getProductQuantity());
    }
}
