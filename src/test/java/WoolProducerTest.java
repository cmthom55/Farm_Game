import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test class for the {@link WoolProducer} class.
 */
public class WoolProducerTest {

    @Test
    public void testWoolProducerProperties() {
        WoolProducer woolProducer = new WoolProducer();
        assertEquals(0, woolProducer.getWoolProduced());
    }

    @Test
    public void testWoolProductionAndSelling() {
        WoolProducer woolProducer = new WoolProducer();

        woolProducer.produceProduct();
        woolProducer.produceProduct();
        assertEquals(20, woolProducer.getWoolProduced());

        int amountMade = woolProducer.sellProduct();

        assertEquals(600, amountMade);
        assertEquals(0, woolProducer.getWoolProduced());
    }

    @Test
    public void testSoldMessage() {
        WoolProducer woolProducer = new WoolProducer();
        assertEquals("All wool sold!", woolProducer.soldMessage());
    }

    @Test
    public void testGetProductQuantity() {
        WoolProducer woolProducer = new WoolProducer();

        woolProducer.produceProduct();
        woolProducer.produceProduct();

        assertEquals(20, woolProducer.getProductQuantity());
    }
}
