/**
 * The {@code Sheep} class represents a concrete 
 * animal in the farm game, specifically a sheep.
 * It extends the {@link Animal} class and initializes 
 * with default values for health, age, and price.
 * The sheep produces wool using the 
 * {@link WoolProducer} strategy for product production.
 * The class inherits from the {@link Animal} class and 
 * sets the health, age, and price parameters during instantiation.
 * The sheep produces wool as a product, 
 * utilizing the {@link WoolProducer} strategy for wool production.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see Animal
 * @see WoolProducer
 */
public class Sheep extends Animal {
    /**
     * Constructs a sheep with default values 
     * for health, age, and price.
     * The sheep utilizes the 
     * {@link WoolProducer} strategy for wool production.
     */
    public Sheep() {
        super(20, 14, 1, new WoolProducer());
    }
}
