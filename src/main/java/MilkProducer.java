/**
 * The {@code MilkProducer} class represents a concrete 
 * strategy for milk production in a farm game.
 * It implements the {@link ProductProducer} interface, 
 * defining methods for producing, selling, and retrieving milk products.
 * The class maintains the quantity of milk produced and 
 * provides methods to produce and sell milk products.
 * The amount of income generated from selling milk is 
 * calculated based on the quantity produced.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see ProductProducer
 */
public class MilkProducer implements ProductProducer {
    private int milkProduced;

    /**
     * Produces milk products by increasing the quantity of milk produced.
     */
    @Override
    public void produceProduct() {
        this.setMilkProduced(this.getMilkProduced() + 5);
    }

    /**
     * Sells the accumulated milk products and returns the income generated.
     *
     * @return The amount of income generated from selling milk products.
     */
    @Override
    public int sellProduct() {
        int amountMade = milkProduced * 50;
        this.setMilkProduced(0);
        return amountMade;
    }

    /**
     * Retrieves the quantity of milk products currently available.
     *
     * @return The quantity of milk products.
     */
    @Override
    public int getProductQuantity() {
        return milkProduced;
    }

    /**
     * Gets the amount of milk produced.
     *
     * @return The amount of milk produced.
     */
    public int getMilkProduced() {
        return milkProduced;
    }

    /**
     * Sets the amount of milk produced.
     *
     * @param milkProduced The new amount of milk produced.
     */
    public void setMilkProduced(int milkProduced) {
        this.milkProduced = milkProduced;
    }

    /**
     * Retrieves a message indicating that all milk has been sold.
     *
     * @return A message indicating that all milk has been sold.
     */
    public String soldMessage() {
        return "All milk sold!";
    }
}
