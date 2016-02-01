package dmurra47.wheels;

import java.util.ArrayList;

/**
 * Provides a class to treat a set of values as if they were on a "wheel". Implements the Rollable interface.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see Rollable
 */
public class Wheel<T> implements Rollable<T> {

    /**
     * Holds the values the wheels is allowed to take.
     */
    protected ArrayList<T> values = null;
    /**
     * Holds the starting position for the counter.
     */
    protected Integer startPos = 0;
    /**
     * Holds the position of the wheel in the values array.
     */
    private Integer counter = 0;
    /**
     * States whether the wheel had rolled over in the last increase() call.
     */
    private boolean rolled = false;

    /**
     * Constructs a wheel with specified values, and defaults to the first item in the list for reset.
     *
     * @param validValues contains the valid values for the wheel. Must not be empty.
     * @throws NullPointerException validValues was null.
     */
    public Wheel(ArrayList<T> validValues) throws NullPointerException {
        // Verify that the passed array is valid, otherwise throw a NullPointerException
        if (validValues != null) {
            values = validValues;  // Note to future self: T objects cannot be cloned for safety.
        } else
            throw new NullPointerException("Invalid array of valid values!");
    }

    /**
     * Constructs a wheel with specified values and start position, and defaults to the first item in the list for reset.
     *
     * @param validValues Contains the valid values for the wheel. Cannot be null.
     * @param start       Contains the start position in validValues; start position = start % validValues.size()
     * @throws NullPointerException validValues was null.
     */
    public Wheel(ArrayList<T> validValues, int start) throws NullPointerException {
        // Verify that the passed array is valid, otherwise throw a NullPointerException
        if (validValues != null) {
            startPos = start % validValues.size();
            counter = startPos;
            values = validValues;  // Note to future self: T objects cannot be cloned for safety.
        } else
            throw new NullPointerException("Invalid array of valid values!");
    }

    /**
     * Resets the wheel to the starting position.
     */
    public void reset() {
        counter = startPos;
    }

    /**
     * Increases the wheel position to the next valid item. Rolls over if there are no more valid items.
     */
    public void increase() {
        counter++;  // Increment the pointing value

        // If the counter has gone past the last valid item, signal a roll over and reset; else clear roll over
        if (counter >= values.size()) {
            rolled = true;
            counter = 0;
        } else {
            rolled = false;
        }
    }

    /**
     * Returns whether or not the wheel had rolled over on the last increase() call.
     *
     * @return Returns wheel roll-over state.
     */
    public boolean lastRolledOver() {
        return rolled;
    }

    /**
     * Returns the current value of the wheel.
     *
     * @return Returns the value of the wheel.
     */
    public T getValue() {
        return values.get(counter);
    }

    /**
     * Simulates a roll-over if part of the values list needs to be skipped early.
     */
    protected void forceRollOver() {
        counter = 0;
        rolled = true;
    }
}
