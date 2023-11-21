/**
 * The {@code ProductProducer} interface defines the contract 
 * for objects that produce and sell products in a farm game.
 * Classes implementing this interface act as strategies 
 * for different types of product production.
 * Implementing classes must provide methods to 
 * produce products, sell products, retrieve the product quantity,
 * and include an optional message related to the sale of products.
 * STRATEGY DESIGN PATTERN
 * 
 * @author Corael Thompson
 * @version 1.0
 * @see MilkProducer
 * @see EggProducer
 * @see WheatCrop
 */
public interface ProductProducer {
    /**
     * Produces a specific product based on the strategy.
     */
    void produceProduct();

    /**
     * Sells the accumulated products and returns the income generated.
     *
     * @return The amount of income generated from selling products.
     */
    int sellProduct();

    /**
     * Retrieves the quantity of products currently available.
     *
     * @return The quantity of products.
     */
    int getProductQuantity();

    /**
     * Retrieves an optional message related to the sale of products.
     *
     * @return A message related to the sale of products, 
     *     or an empty string if no message is available.
     */
    String soldMessage();
}
