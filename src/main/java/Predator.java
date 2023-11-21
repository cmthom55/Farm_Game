/**
 * The {@code Predator} class represents a concrete observer in the farm game, 
 * observing the night cycle for potential hunting activities.
 * It implements the {@link HunterCycleObserver} interface, 
 * allowing predators to participate in 
 * the hunt cycle and specifying their prey preferences.
 * The class initializes with a name and preferred prey. 
 * During the night cycle, the predator 
 * may attempt to hunt with a success probability of 30%.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see HunterCycleObserver
 */
class Predator implements HunterCycleObserver {
    private String name;
    private String prey;

    /**
     * Constructs a {@code Predator} with a specified name and preferred prey.
     *
     * @param name The name of the predator.
     * @param prey The preferred prey of the predator.
     */
    public Predator(String name, String prey) {
        this.setName(name);
        this.setPrey(prey);
    }

    /**
     * Updates the predator about the current hunt cycle, 
     * indicating whether the predator should participate in hunting.
     *
     * @return {@code true} if the predator chooses to hunt successfully, 
     * {@code false} otherwise.
     */
    @Override
    public boolean updateHuntCycle() {
        return hunt();
    }

    /**
     * Simulates a hunting attempt with a success probability of 30%.
     *
     * @return {@code true} if the hunting attempt is successful, 
     * {@code false} otherwise.
     */
    private boolean hunt() {
        double successProbability = Math.random();

        // Predators have a 30% chance of successful hunting
        return successProbability <= 0.30;
    }

    /**
     * Retrieves the name of the predator.
     *
     * @return The name of the predator.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the predator.
     *
     * @param name The new name of the predator.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the preferred prey of the predator.
     *
     * @return The preferred prey of the predator.
     */
    public String getPrey() {
        return prey;
    }

    /**
     * Sets the preferred prey of the predator.
     *
     * @param prey The new preferred prey of the predator.
     */
    public void setPrey(String prey) {
        this.prey = prey;
    }
}
