/**
 * The {@code HunterCycleObserver} interface represents an 
 * observer for the night cycle in a farm game.
 * Observers implement this interface to receive 
 * notifications about the hunt cycle and specify their prey preferences.
 * The {@code updateHuntCycle} method is called when 
 * it is time to update the hunt cycle,
 * and the {@code getPrey} method specifies the observer's prey preferences.
 * OBSERVER DESIGN PATTERN
 * 
 * @author Corael Thompson
 * @version 1.0
 * @see HunterCycle
 */
interface HunterCycleObserver {
    /**
     * Updates the observer about the current hunt cycle.
     *
     * @return A boolean indicating whether the observer should participate in the hunt cycle.
     */
    boolean updateHuntCycle();

    /**
     * Specifies the prey preferences of the observer.
     *
     * @return A string representing the type of prey preferred by the observer.
     */
    String getPrey();
}
