package dmurra47.wheels;

import static dmurra47.wheels.populateNumbersClass.populateNumbers;
import static java.lang.Math.abs;

/**
 * Specialization of Wheel for the context of iterating through days.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see Wheel
 */
public class Day extends Wheel<Integer> {

    /**
     * Holds the maximum days in a month; cannot go over 31.
     */
    private int maxDays = 31;

    /**
     * Default constructor of a Day wheel.
     */
    public Day() {
        super(populateNumbers(31));
    }

    /**
     * Constructor for a Day wheel, allows for the day to start in the middle of the month (1-maxDays, inclusive)
     *
     * @param startDay The day of the year that the wheel is able to start on (1-31, inclusive).
     */
    public Day(int startDay) {
        super(populateNumbers(31));  // Dummy list to initialize the superclass

        if (startDay == 0) {
            startDay = 1;
        }

        super.startPos = abs(startDay - 1) % 31;
    }

    /**
     * Increases the wheel position to the next valid item. Rolls over if there are no more valid items.
     */
    public void increase() {
        super.increase();
        if (maxDays < getValue())
            forceRollOver();
    }

    /**
     * Returns the current maximum days set in this wheel
     *
     * @return Returns the maximum number of days set in this wheel.
     */
    public int getMaxDays() {
        return maxDays;
    }

    /**
     * Sets the maximum number of days this wheel should count up to.
     *
     * @param newMax The number of days that this wheel should count up (1-31, inclusive)
     */
    public void setMaxDays(int newMax) {
        maxDays = abs(newMax - 1) % 31;
        if (maxDays < getValue())
            forceRollOver();
    }
}
