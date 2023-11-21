/**
 * The {@code WheatCrop} class represents a 
 * crop of wheat in the farm game.
 * It encapsulates information about the wheat crop, 
 * including buy and sell prices,
 * the need for replanting, and the amount of wheat produced.
 * The class initializes with default values 
 * for buy price, sell price, and replanting status.
 * It provides methods to produce wheat, 
 * sell the accumulated wheat, and retrieve relevant information.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see CropFarmingDecorator
 * @see WheatCropDecorator
 */
public class WheatCrop {
    private int buyPrice;
    private int sellPrice;
    private boolean needsReplanting;
    private int wheatProduced;

    /**
     * Constructs a wheat crop with default values 
     * for buy price, sell price, and no need for replanting.
     */
    public WheatCrop() {
        this.setBuyPrice(5);
        this.sellPrice = 30;
        this.needsReplanting = false;
        this.wheatProduced = 0;
    }

    /**
     * Produces a quantity of wheat when invoked.
     */
    public void produceProduct() {
        this.setWheatProduced(this.getWheatProduced() + 10);
    }

    /**
     * Sells the accumulated wheat and returns the income generated.
     *
     * @return The amount of income generated from selling wheat.
     */
    public int sellProduct() {
        int amountMade = wheatProduced * sellPrice;
        this.setWheatProduced(0);
        return amountMade;
    }

    /**
     * Retrieves the buy price of the wheat crop.
     *
     * @return The buy price of the wheat crop.
     */
    public int getBuyPrice() {
        return buyPrice;
    }

    /**
     * Sets the buy price of the wheat crop.
     *
     * @param buyPrice The new buy price of the wheat crop.
     */
    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * Checks if the wheat crop needs replanting.
     *
     * @return {@code true} if the wheat crop needs replanting, 
     * {@code false} otherwise.
     */
    public boolean needsReplanting() {
        return needsReplanting;
    }

    /**
     * Sets the replanting status of the wheat crop.
     *
     * @param needsReplanting The new replanting status of the wheat crop.
     */
    public void setNeedsReplanting(boolean needsReplanting) {
        this.needsReplanting = needsReplanting;
    }

    /**
     * Retrieves the sell price of the wheat crop.
     *
     * @return The sell price of the wheat crop.
     */
    public int getSellPrice() {
        return sellPrice;
    }

    /**
     * Sets the sell price of the wheat crop.
     *
     * @param sellPrice The new sell price of the wheat crop.
     */
    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * Retrieves the amount of wheat produced by the crop.
     *
     * @return The amount of wheat produced by the crop.
     */
    public int getWheatProduced() {
        return wheatProduced;
    }

    /**
     * Sets the amount of wheat produced by the crop.
     *
     * @param wheatProduced The new amount of wheat produced by the crop.
     */
    public void setWheatProduced(int wheatProduced) {
        this.wheatProduced = wheatProduced;
    }
}
