/**
 * The {@code CropFarmingDecorator} class is a concrete decorator for the {@link Farmer} interface,
 * adding functionality related to crop farming affinity.
 * It extends the base functionality of a farmer by allowing the farmer to sell resources,
 * including products from animals and wheat crops, with specific pricing rules.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see Farmer
 * @see Animal
 * @see WheatCrop
 */
public class CropFarmingDecorator implements FarmerDecorator {
    private Farmer farmer = new Farmer();

    /**
     * Constructs a new {@code CropFarmingDecorator} object by wrapping the provided {@code farmer}.
     *
     * @param farmer The farmer to be decorated with crop farming affinity.
     */
    public CropFarmingDecorator(Farmer farmer) {
        this.farmer.setAnimalsOnFarm(farmer.getAnimalsOnFarm());
        this.farmer.setFarm(farmer.getFarm());
        this.farmer.setTotalIncome(farmer.getTotalIncome());
        this.farmer.setFarmerBuddies(farmer.getFarmerBuddies());
        this.farmer.setWheatCropsOnFarm(farmer.getWheatCropsOnFarm());
    }

    /**
     * Sells resources, including products from animals and wheat crops,
     * and updates the total income of the decorated farmer with specific pricing rules.
     */
    public void sellResources() {
        for (Animal element : farmer.getAnimalsOnFarm()) {
            farmer.setTotalIncome(farmer.getTotalIncome() 
                    + element.getProductProducer().sellProduct());
        }

        for (WheatCrop element : farmer.getWheatCropsOnFarm()) {
            farmer.setTotalIncome(farmer.getTotalIncome() 
                    + element.sellProduct() * 3);
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
