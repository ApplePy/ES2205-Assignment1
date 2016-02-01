package dmurra47.wheels;

import static java.lang.Math.abs;

/**
 * A counter that increments through the years.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see Rollable
 */
public class Year implements Rollable<Integer> {

    /**
     * Contains the year held by this counter.
     */
    private int year;

    /**
     * Contains the starting year held by this counter.
     */
    private int startPos;

    /**
     * Default constructor for Year class; defaults to 1970.
     */
    public Year() {
        year = 1970;
        startPos = 1970;
    }

    /**
     * Constructor for Year class; counter starts on given year.
     *
     * @param year Returns year that the counter starts on (0-infinity).
     */
    public Year(int year) {
        startPos = abs(year);
        this.year = startPos;
    }

    /**
     * Resets the counter to the starting position.
     */
    public void reset() {
        year = startPos;
    }

    /**
     * Increases the counter position to the next year.
     */
    public void increase() {
        year++;
    }

    /**
     * Returns whether or not the counter had rolled over on the last increase() call. This will always return false.
     *
     * @return Returns false.
     */
    public boolean lastRolledOver() {
        return false;
    }

    /**
     * Returns the current value of the counter.
     *
     * @return Returns value of counter.
     */
    public Integer getValue() {
        return year;
    }

    /**
     * Returns if the held year is a leap year.
     *
     * @return Returns true if leap year, false otherwise.
     */
    public boolean isLeapYear() {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}
