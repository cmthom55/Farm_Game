/**
 * The {@code Animal} class represents 
 * an animal in a farming simulation.
 * It includes properties such as buy price, 
 * remaining days to live, disease level, and a product producer.
 */
public class Animal {
    private final int buyPrice;
    private int daysLeftToLive;
    private int diseaseLevel;
    private ProductProducer productProducer;

    /**
     * Constructs an {@code Animal} object with the specified parameters.
     *
     * @param buyPrice The buy price of the animal.
     * @param daysLeftToLive The remaining days the animal has to live.
     * @param diseaseLevel The disease level of the animal.
     * @param productProducer The product producer associated with the animal.
     */
    public Animal(int buyPrice, int daysLeftToLive, 
            int diseaseLevel, ProductProducer productProducer) {
        this.buyPrice = buyPrice;
        this.daysLeftToLive = daysLeftToLive;
        this.diseaseLevel = diseaseLevel;
        this.productProducer = productProducer;
    }

    /**
     * Updates the remaining days to live based on the disease level.
     *
     * @return {@code true} if the animal has remaining days to live, 
     * {@code false} otherwise.
     */
    public boolean updateDaysRemaining() {
        daysLeftToLive = daysLeftToLive - (1 * diseaseLevel);
        return daysLeftToLive >= 0;
    }

    /**
     * Sets the animal as sick by adjusting the disease level.
     */
    public void setSick() {
        diseaseLevel = 3;
    }

    /**
     * Heals the animal by resetting the disease level.
     */
    public void heal() {
        diseaseLevel = 1;
    }

    /**
     * Gets the buy price of the animal.
     *
     * @return The buy price of the animal.
     */
    public int getBuyPrice() {
        return buyPrice;
    }

    /**
     * Produces a product using the associated product producer and sells the product.
     */
    public void produceProduct() {
        productProducer.produceProduct();
        productProducer.sellProduct();
    }

    /**
     * Gets the quantity of the product produced by the animal.
     *
     * @return The quantity of the product produced by the animal.
     */
    public int getProductQuantity() {
        return productProducer.getProductQuantity();
    }

    /**
     * Sets the product producer associated with the animal.
     *
     * @param productProducer The product producer to be set.
     */
    public void setProductProducer(ProductProducer productProducer) {
        this.productProducer = productProducer;
    }

    /**
     * Gets the product producer associated with the animal.
     *
     * @return The product producer associated with the animal.
     */
    public ProductProducer getProductProducer() {
        return this.productProducer;
    }

    /**
     * Gets the remaining days for the animal to live.
     *
     * @return The remaining days for the animal to live.
     */
    public int getDaysLeftToLive() {
        return daysLeftToLive;
    }

    /**
     * Sets the remaining days for the animal to live.
     *
     * @param daysLeftToLive The remaining days to be set.
     */
    public void setDaysLeftToLive(int daysLeftToLive) {
        this.daysLeftToLive = daysLeftToLive;
    }

    /**
     * Gets the disease level of the animal.
     *
     * @return The disease level of the animal.
     */
    public int getDiseaseLevel() {
        return diseaseLevel;
    }

    /**
     * Sets the disease level of the animal.
     *
     * @param diseaseLevel The disease level to be set.
     */
    public void setDiseaseLevel(int diseaseLevel) {
        this.diseaseLevel = diseaseLevel;
    }
}
