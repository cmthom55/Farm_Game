import java.util.ArrayList;

/**
 * The {@code Farmer} class represents a concrete 
 * implementation of a farmer in a farming simulation game.
 * It manages the farmer's total income, activities, 
 * animals, crops, and interactions with the farm.
 * The farmer can perform daily activities, calculate income, 
 * and buy resources such as animals, crops, and upgrades.
 * The farmer is associated with a {@link Farm} 
 * and can manage animals and wheat crops on the farm.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see Farm
 * @see Animal
 * @see WheatCrop
 */
public class Farmer {
    private double totalIncome;
    private ArrayList<Animal> animalsOnFarm = new ArrayList<Animal>();
    private ArrayList<WheatCrop> wheatCropsOnFarm = new ArrayList<WheatCrop>();
    private int farmerBuddies;
    private Farm farm = new Farm();

    /**
     * Default constructor for the {@code Farmer} class.
     * Initializes the total income, farmer buddies, and the associated farm.
     */
    public Farmer() {
        this.totalIncome = 0;
        setFarmerBuddies(0);
        this.setFarm(new Farm());
    }

    /**
     * Gets the total income of the farmer.
     *
     * @return The total income of the farmer.
     */
    public double getTotalIncome() {
        return totalIncome;
    }

    /**
     * Sets the total income of the farmer.
     *
     * @param totalIncome The total income of the farmer.
     */
    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * Performs the base daily activities of the farmer.
     */
    void performDailyActivities() {
        System.out.println("Base daily activities performed by the farmer.");
    }

    /**
     * Calculates the income of the farmer.
     *
     * @return The calculated income of the farmer.
     */
    double calculateIncome() {
        return totalIncome;
    }

    /**
     * Gets the list of animals on the farm.
     *
     * @return The list of animals on the farm.
     */
    public ArrayList<Animal> getAnimalsOnFarm() {
        return new ArrayList<>(animalsOnFarm);
    }

    /**
     * Sets the list of animals on the farm.
     *
     * @param animalsOnFarm The list of animals on the farm.
     */
    public void setAnimalsOnFarm(ArrayList<Animal> animalsOnFarm) {
        this.animalsOnFarm = new ArrayList<>(animalsOnFarm);
    }

    /**
     * Gets the list of wheat crops on the farm.
     *
     * @return The list of wheat crops on the farm.
     */
    public ArrayList<WheatCrop> getWheatCropsOnFarm() {
        return new ArrayList<>(wheatCropsOnFarm);
    }

    /**
     * Sets the list of wheat crops on the farm.
     *
     * @param wheatCropsOnFarm The list of wheat crops on the farm.
     */
    public void setWheatCropsOnFarm(ArrayList<WheatCrop> wheatCropsOnFarm) {
        this.wheatCropsOnFarm = new ArrayList<>(wheatCropsOnFarm);
    }

    /**
     * Buys resources based on the available total income.
     * Resources include animals, crops, farmer buddies, and farm upgrades.
     */
    public void buyResources() {
        while (totalIncome >= 10) {
            if (totalIncome >= 500 && (farmerBuddies % 10 != 0 || farmerBuddies == 0)) {
                farmerBuddies++;
                totalIncome = totalIncome - 500;
            } else if (totalIncome >= 1000) {
                int whichTypeOfUpgrade = farm.tryUpgrade(this.getTotalIncome());
                if (whichTypeOfUpgrade == 3) {
                    this.totalIncome = totalIncome - 3000;
                } else {
                    this.totalIncome = totalIncome - 1000;
                }
            } else if (totalIncome >= 40) {
                animalsOnFarm.add(new Cow());
                totalIncome = totalIncome - 40;
            } else if (totalIncome >= 20) {
                animalsOnFarm.add(new Sheep());
                totalIncome = totalIncome - 20;
            } else if (totalIncome >= 15) {
                wheatCropsOnFarm.add(new WheatCrop());
                totalIncome = totalIncome - 15;
            } else if (totalIncome >= 10) {
                animalsOnFarm.add(new Chicken());
                totalIncome = totalIncome - 10;
            }
        }
    }

    /**
     * Gets the number of farmer buddies.
     *
     * @return The number of farmer buddies.
     */
    public int getFarmerBuddies() {
        return farmerBuddies;
    }

    /**
     * Sets the number of farmer buddies.
     *
     * @param farmerBuddies The number of farmer buddies.
     */
    public void setFarmerBuddies(int farmerBuddies) {
        this.farmerBuddies = farmerBuddies;
    }

    /**
     * Gets the associated farm of the farmer.
     *
     * @return The associated farm of the farmer.
     */
    public Farm getFarm() {
        Farm farmCopy = new Farm();
        farmCopy.setLevel(this.farm.getLevel());
        farmCopy.setMaxAnimalCapacity(this.farm.getMaxAnimalCapacity());
        farmCopy.setMaxCropsCapacity(this.farm.getMaxCropsCapacity());
        farmCopy.setMaxCapacity(this.farm.getMaxCapacity());
        farmCopy.setNumOfFarms(this.farm.getNumOfFarms());
        return farmCopy;
    }

    /**
     * Sets the associated farm of the farmer.
     *
     * @param farm The associated farm of the farmer.
     */
    public void setFarm(Farm farm) {
        this.farm.setLevel(farm.getLevel());
        this.farm.setMaxAnimalCapacity(farm.getMaxAnimalCapacity());
        this.farm.setMaxCapacity(farm.getMaxCapacity());
        this.farm.setMaxCropsCapacity(farm.getMaxCropsCapacity());
        this.farm.setNumOfFarms(farm.getNumOfFarms());
    }
}
