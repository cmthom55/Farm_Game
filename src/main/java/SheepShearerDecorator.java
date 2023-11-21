/**
 * The {@code SheepShearerDecorator} class represents a concrete decorator for
 * a farmer's sheep-shearing affinity in a farm game.
 * It implements the {@link FarmerDecorator} interface, enhancing the 
 * farmer's ability to generate income by selling resources.
 * This decorator specifically boosts the income from selling 
 * wool produced by sheep, multiplying it by a factor of 5. The class 
 * decorates a {@link Farmer} instance and overrides the {@code sellResources} method 
 * to sell animals, crops, and enhance the income from selling wool 
 * produced by sheep by multiplying it by a factor of 5.
 * This decorator enhances the farmer's sheep-shearing capabilities.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see FarmerDecorator
 * @see Farmer
 * @see Sheep
 */
public class SheepShearerDecorator implements FarmerDecorator {
    private Farmer farmer = new Farmer();

    /**
     * Constructs a {@code SheepShearerDecorator} with a specified farmer to decorate.
     *
     * @param farmer The farmer to be decorated.
     */
    public SheepShearerDecorator(Farmer farmer) {
        this.farmer.setAnimalsOnFarm(farmer.getAnimalsOnFarm());
        this.farmer.setFarm(farmer.getFarm());
        this.farmer.setTotalIncome(farmer.getTotalIncome());
        this.farmer.setFarmerBuddies(farmer.getFarmerBuddies());
        this.farmer.setWheatCropsOnFarm(farmer.getWheatCropsOnFarm());
    }

    /**
     * Sells resources, including animals, crops, and enhances 
     * the income from selling wool produced by sheep by a factor of 5.
     */
    @Override
    public void sellResources() {
        for (Animal element : farmer.getAnimalsOnFarm()) {
            if (element instanceof Sheep) {
                farmer.setTotalIncome(farmer.getTotalIncome() 
                        + element.getProductProducer().sellProduct() * 5);
            } else {
                farmer.setTotalIncome(farmer.getTotalIncome() 
                        + element.getProductProducer().sellProduct());
            }
        }

        for (WheatCrop element : farmer.getWheatCropsOnFarm()) {
            farmer.setTotalIncome(farmer.getTotalIncome() + element.sellProduct());
        }
    }
    
    /**
     * Gets a copy of the decorated farmer.
     *
     * @return A copy of the decorated farmer.
     */
    public Farmer getFarmer() {
        Farmer farmerCopy = new Farmer();
        farmerCopy.setAnimalsOnFarm(this.farmer.getAnimalsOnFarm());
        farmerCopy.setWheatCropsOnFarm(this.farmer.getWheatCropsOnFarm());
        farmerCopy.setFarm(this.farmer.getFarm());
        farmerCopy.setFarmerBuddies(this.farmer.getFarmerBuddies());
        farmerCopy.setTotalIncome(this.farmer.getTotalIncome());
        return farmerCopy;
    }

    /**
     * Sets the decorated farmer.
     *
     * @param farmer The new farmer to be decorated with crop farming affinity.
     */
    public void setFarmer(Farmer farmer) {
        this.farmer.setAnimalsOnFarm(farmer.getAnimalsOnFarm());
        this.farmer.setWheatCropsOnFarm(farmer.getWheatCropsOnFarm());
        this.farmer.setFarm(farmer.getFarm());
        this.farmer.setFarmerBuddies(farmer.getFarmerBuddies());
        this.farmer.setTotalIncome(farmer.getTotalIncome());   
    } 
}
