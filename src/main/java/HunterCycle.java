import java.util.ArrayList;
import java.util.Iterator;

/**
 * The {@code HunterCycle} class represents a concrete 
 * subject that simulates night cycles in a farm game.
 * It notifies observers when it is time to hunt and 
 * provides a mechanism for observers to update the hunt cycle.
 * The class maintains lists of animals and wheat crops 
 * that can be hunted during the night.
 * Observers are informed about the hunt cycle,
 * and based on their preferences, animals or crops are removed
 * from the available list of targets.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see HunterCycleObserver
 * @see Predator
 * @see Animal
 * @see WheatCrop
 */
class HunterCycle implements HunterCycleSubject {
    private ArrayList<HunterCycleObserver> observers = new ArrayList<>();
    private ArrayList<Animal> animalsOnFarmToEat = new ArrayList<>();
    private ArrayList<WheatCrop> wheatCropsToEat = new ArrayList<>();
    private boolean animalsEaten = false;
    private boolean wheatEaten = false;

    /**
     * Sets whether it is time to initiate the hunt cycle.
     *
     * @param timeToHunt A boolean value indicating whether it is time to hunt.
     */
    public void setTimeToHunt(boolean timeToHunt) {
        if (timeToHunt == true) {
            notifyObservers();  
        }
    }

    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    @Override
    public void addObserver(HunterCycleObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    @Override
    public void removeObserver(HunterCycleObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers about the hunt cycle and 
     * updates the available targets based on their preferences.
     */
    @Override
    public void notifyObservers() {
        for (HunterCycleObserver observer : observers) {
            if (observer.updateHuntCycle()) {
                String prey = observer.getPrey();
                if ("Cow".equals(prey)) {
                    this.setAnimalsEaten(true);
                    removeFirstCow();
                } else if ("Sheep".equals(prey)) {
                    removeFirstSheep();
                    this.setAnimalsEaten(true);
                } else if ("Wheat".equals(prey)) {
                    removeFirstWheat();
                    this.setWheatEaten(true);
                } else if ("Chicken".equals(prey)) {
                    removeFirstChicken();
                    this.setAnimalsEaten(true);
                }
            }
        }
    }

    // Helper method to remove the first cow from the list
    private void removeFirstCow() {
        Iterator<Animal> iterator = animalsOnFarmToEat.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal instanceof Cow) {
                iterator.remove();
                break; // Stop after removing the first cow
            }
        }
    }

    // Helper method to remove the first sheep from the list
    private void removeFirstSheep() {
        Iterator<Animal> iterator = animalsOnFarmToEat.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal instanceof Sheep) {
                iterator.remove();
                break; // Stop after removing the first sheep
            }
        }
    }

    // Helper method to remove the first wheat crop from the list
    private void removeFirstWheat() {
        if (!wheatCropsToEat.isEmpty()) {
            wheatCropsToEat.remove(0);
        }
    }

    // Helper method to remove the first chicken from the list
    private void removeFirstChicken() {
        Iterator<Animal> iterator = animalsOnFarmToEat.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal instanceof Chicken) {
                iterator.remove();
                break;
            }
        }
    }
    
    /**
     * Gets the list of animals available for hunting during the night.
     *
     * @return The list of animals available for hunting.
     */
    public ArrayList<Animal> getAnimalsToEat() {
        return animalsOnFarmToEat;
    }

    /**
     * Sets the list of animals available for hunting during the night.
     *
     * @param animalsOnFarmToEat The list of animals available for hunting.
     */
    public void setAnimalsToEat(ArrayList<Animal> animalsOnFarmToEat) {
        this.animalsOnFarmToEat = animalsOnFarmToEat;
    }

    /**
     * Gets the list of wheat crops available for harvesting during the night.
     *
     * @return The list of wheat crops available for harvesting.
     */
    public ArrayList<WheatCrop> getWheatCropsToEat() {
        return wheatCropsToEat;
    }

    /**
     * Sets the list of wheat crops available for harvesting during the night.
     *
     * @param wheatCropsToEat The list of wheat crops available for harvesting.
     */
    public void setWheatCropsToEat(ArrayList<WheatCrop> wheatCropsToEat) {
        this.wheatCropsToEat = wheatCropsToEat;
    }

    public boolean isAnimalsEaten() {
        return animalsEaten;
    }

    public void setAnimalsEaten(boolean animalsEaten) {
        this.animalsEaten = animalsEaten;
    }

    public boolean isWheatEaten() {
        return wheatEaten;
    }

    public void setWheatEaten(boolean wheatEaten) {
        this.wheatEaten = wheatEaten;
    }
}
