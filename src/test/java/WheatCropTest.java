import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test class for the {@link WheatCropTest} class.
 */
public class WheatCropTest {

    @Test
    public void testProduceProduct() {
        WheatCrop wheatCrop = new WheatCrop();
        
        assertEquals(0, wheatCrop.getWheatProduced());

        wheatCrop.produceProduct();

        assertEquals(10, wheatCrop.getWheatProduced());
    }

    @Test
    public void testSellProduct() {
        WheatCrop wheatCrop = new WheatCrop();
        
        assertEquals(0, wheatCrop.getWheatProduced());

        wheatCrop.produceProduct();
        
        int amountMade = wheatCrop.sellProduct();

        assertEquals(0, wheatCrop.getWheatProduced());

        assertEquals(10 * wheatCrop.getSellPrice(), amountMade);
    }

    @Test
    public void testNeedsReplanting() {
        WheatCrop wheatCrop = new WheatCrop();

        assertFalse(wheatCrop.needsReplanting());

        wheatCrop.setNeedsReplanting(true);

        assertTrue(wheatCrop.needsReplanting());
    }
}
