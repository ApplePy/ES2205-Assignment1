package dmurra47.wheels;

/**
 * Specifies the required functions that need to be implemented in a wheel counter.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 */
public interface WheelCounterInterface<T> {

    /**
     * Resets all the wheels back to their starting position.
     */
    void reset();

    /**
     * Increments the wheels in a cascading fashion; ie if a preceding wheel has rolled over, the next wheel increments.
     */
    void increase();

    /**
     * Get the value of one of the wheels under this counter's control.
     *
     * @param theWheel The wheel whose value you want to return.
     * @return Returns the value of the selected wheel.
     */
    T getWheelValue(int theWheel);

    /**
     * Returns the number of wheels under the control of the wheel counter.
     *
     * @return Returns the number of wheels being used.
     */
    int getWheelsInUse();

}
