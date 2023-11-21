/**
 * The {@code MoneyMakerDecorator} class represents a 
 * concrete decorator for a farmer's money-making affinity in a farm game.
 * It implements the {@link FarmerDecorator} interface, 
 * enhancing the farmer's ability to generate income by selling resources.
 * The class decorates a {@link Farmer} instance and overrides the {@code sellResources} 
 * method to sell animals, crops, and multiply the total income by a factor of 3.
 * This decorator enhances the farmer's money-making capabilities.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see FarmerDecorator
 * @see Farmer
 */
public class MoneyMakerDecorator implements FarmerDecorator {
    private Farmer farmer = new Farmer();

    /**
     * Constructs a {@code MoneyMakerDecorator} 
     * with a specified farmer to decorate.
     *
     * @param farmer The farmer to be decorated.
     */
    public MoneyMakerDecorator(Farmer farmer) {
        this.farmer.setAnimalsOnFarm(farmer.getAnimalsOnFarm());
        this.farmer.setFarm(farmer.getFarm());
        this.farmer.setTotalIncome(farmer.getTotalIncome());
        this.farmer.setFarmerBuddies(farmer.getFarmerBuddies());
        this.farmer.setWheatCropsOnFarm(farmer.getWheatCropsOnFarm());
    }

    /**
     * Sells resources, including animals, crops, 
     * and multiplies the total income by a factor of 3.
     */
    @Override
    public void sellResources() {
        for (Animal element : farmer.getAnimalsOnFarm()) {
            farmer.setTotalIncome(farmer.getTotalIncome() 
                    + element.getProductProducer().sellProduct());
        }

        for (WheatCrop element : farmer.getWheatCropsOnFarm()) {
            farmer.setTotalIncome(farmer.getTotalIncome() + element.sellProduct());
        }

        farmer.setTotalIncome(farmer.getTotalIncome() * 3);
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
