/**
 * The {@code FarmerDecorator} interface represents the 
 * component interface for decorating a farmer in a farming simulation game.
 * It defines the method for selling resources, 
 * allowing decorators to add functionality related to resource selling.
 * DECORATOR DESIGN PATTERN
 * @author Corael Thompson
 * @version 1.0
 * @see CropFarmingDecorator
 */
public interface FarmerDecorator {
    /**
     * Sells resources, adding functionality related to resource selling.
     */
    void sellResources();
}
