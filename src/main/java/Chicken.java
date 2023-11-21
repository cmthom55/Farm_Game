/**
 * The {@code Chicken} class represents a concrete implementation of the {@link Animal} class,
 * specializing in the characteristics and behavior of a chicken.
 * It extends the base class and uses an {@link EggProducer} to handle egg production.
 * The default constructor initializes the chicken with specific values for age, weight, and health,
 * and associates it with an {@code EggProducer} instance for egg-related functionality.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see Animal
 * @see EggProducer
 */
public class Chicken extends Animal {
    /**
     * Constructs a new {@code Chicken} object with default values.
     * The age is set to 10, weight to 15, and health to 1.
     * It uses an {@code EggProducer} for egg-related functionality.
     */
    public Chicken() {
        super(10, 15, 1, new EggProducer());
    }
}
