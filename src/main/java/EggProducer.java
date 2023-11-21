/**
 * The {@code EggProducer} class is a concrete implementation 
 * of the {@link ProductProducer} interface,
 * representing a strategy for egg production.
 * It keeps track of the number of eggs produced and 
 * provides methods to produce, sell, and get information about eggs.
 * The selling price for eggs is set at 150 units each, and after selling, 
 * the number of eggs produced is reset to zero.
 * The class also provides a method {@code soldMessage()} 
 * that returns a message indicating all eggs have been sold.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see ProductProducer
 */
public class EggProducer implements ProductProducer {
    private int eggsProduced;

    /**
     * Produces one egg, incrementing the count of eggs produced.
     */
    @Override
    public void produceProduct() {
        this.setEggsProduced(this.getEggsProduced() + 1);
    }

    /**
     * Sells all eggs, resets the count to zero, and returns the total income from selling the eggs.
     *
     * @return The total income from selling all eggs.
     */
    @Override
    public int sellProduct() {
        int amountMade = eggsProduced * 150;
        this.setEggsProduced(0);
        return amountMade;
    }

    /**
     * Gets the current quantity of eggs produced.
     *
     * @return The quantity of eggs produced.
     */
    @Override
    public int getProductQuantity() {
        return eggsProduced;
    }

    /**
     * Gets the number of eggs produced.
     *
     * @return The number of eggs produced.
     */
    public int getEggsProduced() {
        return eggsProduced;
    }

    /**
     * Sets the number of eggs produced.
     *
     * @param eggsProduced The number of eggs produced.
     */
    public void setEggsProduced(int eggsProduced) {
        this.eggsProduced = eggsProduced;
    }

    /**
     * Returns a message indicating that all eggs have been sold, and they are also golden.
     *
     * @return A message indicating that all eggs have been sold, and they are also golden.
     */
    public String soldMessage() {
        return "All eggs sold, they are also golden hooray!";
    }
}
