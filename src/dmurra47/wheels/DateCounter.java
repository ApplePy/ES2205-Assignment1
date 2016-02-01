package dmurra47.wheels;

import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Controls a collection of wheels in order to increment them in proper sequence. Extends WheelCounter.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see WheelCounter
 */
public class DateCounter extends WheelCounter<Object> {

    /**
     * Array of counters, holding the day, month, year, and day of week counters (in that order).
     */
    private ArrayList<Rollable> counters;  // Holds the wheels to be counted

    /**
     * Holds the Day counter of the date.
     */
    private Day day;

    /**
     * Holds the Month counter of the date.
     */
    private Month month;

    /**
     * Holds the Year counter of the date.
     */
    private Year year;

    /**
     * Holds the DayOfTheWeek counter of the date.
     */
    private DayOfWeek dayOfWeek;

    /**
     * Default constructor initializes the counter with the wheels that will be used. Defaults to Jan 1, 1970.
     */
    public DateCounter() {
        super(new ArrayList<>()); // Dummy parameter

        this.day = new Day();
        this.month = new Month();
        this.year = new Year();
        dayOfWeek = new DayOfWeek(this.day, this.month, this.year);

        counters = new ArrayList<>();
        counters.add(this.day);
        counters.add(this.month);
        counters.add(this.year);
        counters.add(dayOfWeek);
    }

    /**
     * Constructor initializes the counter with the wheels that will be used.
     *
     * @param day   The day the counter initializes with (1-31, inclusive)
     * @param month The month the counter initializes with (1-12, inclusive)
     * @param year  THe year the counter initializes with (1-infinity)
     */
    public DateCounter(int day, int month, int year) {
        super(new ArrayList<>()); // Dummy parameter

        this.day = new Day(abs(day % 31));
        this.month = new Month(abs(month % 12));
        this.year = new Year(abs(year));
        dayOfWeek = new DayOfWeek(this.day, this.month, this.year);

        //Properly set max days
        switch (this.month.getMonthNum()) {
            case 2:
                if (this.year.isLeapYear()) {
                    this.day.setMaxDays(this.month.getMonthLength() + 1);
                    break;
                }
            default:
                this.day.setMaxDays(this.month.getMonthLength());
                break;
        }

        // Error-checking
        if (this.day.getMaxDays() > day) {
            this.day = new Day();  // Replace the defective object with a new default one
        }

        // Add counters to array
        counters = new ArrayList<>();
        counters.add(this.day);
        counters.add(this.month);
        counters.add(this.year);
        counters.add(dayOfWeek);
    }

    /**
     * Resets all the wheels back to their starting position.
     */
    public void reset() {
        for (Rollable i : counters) {
            i.reset();
        }
    }

    /**
     * Increments the wheels in a cascading fashion; ie if a preceding wheel has rolled over, the next wheel increments.
     */
    public void increase() {

        // Properly set the maximum day given the current month/year
        if (day.lastRolledOver()) {
            switch (month.getMonthNum()) {
                case 2:
                    if (year.isLeapYear()) {
                        day.setMaxDays(month.getMonthLength() + 1);
                        break;
                    }
                default:
                    day.setMaxDays(month.getMonthLength());
                    break;
            }
        }

        dayOfWeek.increase();

        // Increment the first wheel, increment the proceeding ones if the previous wheel rolled over; else break
        for (int i = 0; i < counters.size() - 1; i++) {
            counters.get(i).increase();
            if (!counters.get(i).lastRolledOver())
                break;
        }
    }

    /**
     * Get the value of one of the wheels under this counter's control.
     *
     * @param theWheel The wheel whose value you want to return.
     * @return Returns the value of the selected wheel.
     */
    public Object getWheelValue(int theWheel) {
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
