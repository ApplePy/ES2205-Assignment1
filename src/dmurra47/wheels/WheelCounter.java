package dmurra47.wheels;

import java.util.ArrayList;

/**
 * Controls a collection of wheels in order to increment them in proper sequence. Implements WheelCounterInterface.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see WheelCounterInterface
 */
public class WheelCounter<T> implements WheelCounterInterface<T> {

    /**
     * Contains the counters that the wheel must increment.
     */
    protected ArrayList<Rollable<T>> counters;  // Holds the wheels to be counted

    /**
     * Constructor initializes the counter with the wheels that will be used.
     *
     * @param newWheels Contains the wheels that the wheel counter will be incrementing. Must not be empty.
     * @throws NullPointerException newWheels was null.
     */
    public WheelCounter(ArrayList<Rollable<T>> newWheels) throws NullPointerException {
        // Verify that the passed array is valid, otherwise throw a NullPointerException
        if (newWheels != null)
            counters = newWheels;
        else
            throw new NullPointerException("Invalid array of wheel objects!");
    }

    /**
     * Resets all the wheels back to their starting position.
     */
    public void reset() {
        for (Rollable<T> i : counters) {
            i.reset();
        }
    }

    /**
     * Increments the wheels in a cascading fashion; ie if a preceding wheel has rolled over, the next wheel increments.
     */
    public void increase() {
        // Increment the first wheel, increment the proceeding ones if the previous wheel rolled over; else break
        for (Rollable<T> i : counters) {
            i.increase();
            if (!i.lastRolledOver())
                break;
        }
    }

    /**
     * Get the value of one of the wheels under this counter's control.
     *
     * @param theWheel The wheel whose value you want to return.
     * @return Returns the value of the selected wheel.
     */
    public T getWheelValue(int theWheel) {
        return counters.get(theWheel).getValue();
    }

    /**
     * Returns the number of wheels under the control of the wheel counter.
     *
     * @return Returns the number of wheels being used.
     */
    public int getWheelsInUse() {
        return counters.size();
    }

}
