/**
 * The {@code WoolProducer} class represents 
 * a strategy for wool production in the farm game.
 * It implements the {@code ProductProducer} interface.
 * The class initializes with default values for wool production. 
 * It allows the production of wool, selling the accumulated wool, 
 * and retrieving information about the produced wool quantity.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see ProductProducer
 * @see Sheep
 * @see SheepShearerDecorator
 */
public class WoolProducer implements ProductProducer {
    private int woolProduced;

    /**
     * Produces a quantity of wool when invoked.
     */
    @Override
    public void produceProduct() {
        this.setWoolProduced(this.getWoolProduced() + 10);
    }

    /**
     * Sells the accumulated wool and returns the income generated.
     *
     * @return The amount of income generated from selling wool.
     */
    @Override
    public int sellProduct() {
        int amountMade = woolProduced * 30;
        this.setWoolProduced(0);
        return amountMade;
    }

    /**
     * Retrieves the quantity of wool produced.
     *
     * @return The quantity of wool produced.
     */
    @Override
    public int getProductQuantity() {
        return woolProduced;
    }

    /**
     * Retrieves the amount of wool produced by the strategy.
     *
     * @return The amount of wool produced.
     */
    public int getWoolProduced() {
        return woolProduced;
    }

    /**
     * Sets the amount of wool produced by the strategy.
     *
     * @param woolProduced The new amount of wool produced.
     */
    public void setWoolProduced(int woolProduced) {
        this.woolProduced = woolProduced;
    }

    /**
     * Retrieves a message indicating that all wool has been sold.
     *
     * @return A message indicating that all wool has been sold.
     */
    public String soldMessage() {
        return "All wool sold!";
    }
}
