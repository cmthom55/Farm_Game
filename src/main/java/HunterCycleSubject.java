/**
 * The {@code HunterCycleSubject} interface represents a 
 * subject for the night cycle in a farm game.
 * Subjects implement this interface to manage a 
 * list of observers and notify them about changes in the hunt cycle.
 * The {@code addObserver} method adds an observer 
 * to the list, {@code removeObserver} removes an observer,
 * and {@code notifyObservers} notifies 
 * all observers about changes in the hunt cycle.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see HunterCycleObserver
 */
interface HunterCycleSubject {
    /**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
    void addObserver(HunterCycleObserver observer);

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(HunterCycleObserver observer);

    /**
     * Notifies all observers about changes in the hunt cycle.
     */
    void notifyObservers();
}
