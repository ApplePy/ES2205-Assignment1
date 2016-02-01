package dmurra47.wheels;

/**
 * Set of functions needed in a class that behaves like a "wheel".
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 */

public interface Rollable<T> {

    /**
     * Resets the wheel to the starting position.
     */
    void reset();

    /**
     * Increases the wheel position to the next valid item. Rolls over if there are no more valid items.
     */
    void increase();

    /**
     * Returns whether or not the wheel had rolled over on the last increase() call.
     *
     * @return wheel roll-over state
     */
    boolean lastRolledOver();

    /**
     * Returns the current value of the wheel.
     *
     * @return value of wheel
     */
    T getValue();

}
