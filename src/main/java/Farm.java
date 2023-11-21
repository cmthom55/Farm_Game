/**
 * The {@code Farm} class represents a farm in a farming simulation game.
 * It keeps track of the farm's level, 
 * number of farms, the main farmer, and various capacity limits.
 * The farm can be upgraded based on the available money in possession.
 * The farm has different capacity limits for the total 
 * number of items, animals, and crops.
 * Upgrading the farm increases these capacity limits based on the farm's level.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see Farmer
 */
public class Farm {
    private int level;
    private int numOfFarms;
    private int maxCapacity;
    private int maxAnimalCapacity;
    private int maxCropsCapacity;

    /**
     * Constructs a new {@code Farm} object with default values.
     */
    public Farm() {
        this.level = 1;
        this.setNumOfFarms(1);
        this.setMaxCapacity(10);
        this.setMaxAnimalCapacity(20);
        this.setMaxCropsCapacity(50);
    }

    /**
     * Attempts to upgrade the farm based on the available money in possession.
     * The upgrade increases capacity limits for items, animals, and crops.
     *
     * @param moneyInPossession The amount of money available for the upgrade.
     * @return An integer code indicating the result of the upgrade attempt.
     */
    public int tryUpgrade(double moneyInPossession) {
        // Upgrade conditions based on the farm's level
        if (level % 3 != 0) {
            if (level % 3 == 2) {
                if (moneyInPossession >= 3000) {
                    level++;
                    setMaxCapacity(getMaxCapacity() + 10);
                    maxAnimalCapacity += 20;
                    maxCropsCapacity += 50;
                    return 3;
                }
            }

            if (level % 3 == 1) {
                if (moneyInPossession >= 1000) {
                    level++;
                    setMaxCapacity(getMaxCapacity() + 10);
                    maxAnimalCapacity += 20;
                    maxCropsCapacity += 50;
                    return 2;
                }
            }
        } else {
            if (moneyInPossession >= 750) {
                numOfFarms++;
                setMaxCapacity(getMaxCapacity() + 10);
                maxAnimalCapacity += 20;
                maxCropsCapacity += 50;
                return 4;
            }
        }
        return 0;
    }

    /**
     * Gets the number of farms.
     *
     * @return The number of farms.
     */
    public int getNumOfFarms() {
        return numOfFarms;
    }

    /**
     * Sets the number of farms.
     *
     * @param numOfFarms The number of farms.
     */
    public void setNumOfFarms(int numOfFarms) {
        this.numOfFarms = numOfFarms;
    }

    /**
     * Gets the maximum capacity of the farm.
     *
     * @return The maximum capacity of the farm.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets the maximum capacity of the farm.
     *
     * @param maxCapacity The maximum capacity of the farm.
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Gets the maximum animal capacity of the farm.
     *
     * @return The maximum animal capacity of the farm.
     */
    public int getMaxAnimalCapacity() {
        return maxAnimalCapacity;
    }

    /**
     * Sets the maximum animal capacity of the farm.
     *
     * @param maxAnimalCapacity The maximum animal capacity of the farm.
     */
    public void setMaxAnimalCapacity(int maxAnimalCapacity) {
        this.maxAnimalCapacity = maxAnimalCapacity;
    }

    /**
     * Gets the maximum crops capacity of the farm.
     *
     * @return The maximum crops capacity of the farm.
     */
    public int getMaxCropsCapacity() {
        return maxCropsCapacity;
    }

    /**
     * Sets the maximum crops capacity of the farm.
     *
     * @param maxCropsCapacity The maximum crops capacity of the farm.
     */
    public void setMaxCropsCapacity(int maxCropsCapacity) {
        this.maxCropsCapacity = maxCropsCapacity;
    }

    /**
     * Gets the level of the farm.
     *
     * @return The level of the farm.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of the farm.
     *
     * @param level The level of the farm.
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
