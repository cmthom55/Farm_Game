/**
 * The {@code Cow} class represents a concrete implementation of the {@link Animal} class,
 * specializing in the characteristics and behavior of a cow.
 * It extends the base class and uses a {@link MilkProducer} to handle milk production.
 * The default constructor initializes the cow with specific values for age, weight, and health,
 * and associates it with a {@code MilkProducer} instance for milk-related functionality.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see Animal
 * @see MilkProducer
 */
public class Cow extends Animal {
    /**
     * Constructs a new {@code Cow} object with default values.
     * The age is set to 40, weight to 14, and health to 1.
     * It uses a {@code MilkProducer} for milk-related functionality.
     */
    public Cow() {
        super(40, 14, 1, new MilkProducer());
    }
}
