package dmurra47.wheels;

import java.util.ArrayList;

import static java.lang.Math.floor;

/**
 * Specialization of Wheel for the context of iterating through days.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see Wheel
 */
public class DayOfWeek extends Wheel<String> {

    /**
     * Constructor of a Day wheel.
     */
    public DayOfWeek(Day day, Month month, Year year) {
        super(new ArrayList<>());  // Dummy list to initialize the superclass

        // Initialize with proper days
        ArrayList<String> Days = new ArrayList<>();
        Days.add("Mon");
        Days.add("Tue");
        Days.add("Wed");
        Days.add("Thu");
        Days.add("Fri");
        Days.add("Sat");
        Days.add("Sun");

        // Create an ArrayList with the proper values
        ArrayList<String> values = new ArrayList<>();
        for (String txt : Days)
            values.add(txt);

        super.values = values;                               // Replace the dummy list with the real list
        super.startPos = setToCorrectStart(day, month, year);  // Set the wheel to start on the correct day

        reset();  // Let changes to startPos take effect.
    }

    /**
     * Provides the correct starting day of the week, given the date.
     *
     * @param day   A day object for the date that you want to find the day of the week.
     * @param month A month object for the date that you want to find the day of the week.
     * @param year  A year object for the date that you want to find the day of the week.
     * @return Returns the numerical day of the week to start on.
     */
    private int setToCorrectStart(Day day, Month month, Year year) {
        int dayNum = day.getValue();
        int monthNum = month.getMonthNum();
        int yearNum = year.getValue();
        int yearOfCentury = yearNum % 100;
        double zeroBasedCent = floor(yearNum / 100);

        return (int) ((dayNum +
                floor(13 * (monthNum + 1) / 5) +
                yearOfCentury +
                floor(yearOfCentury / 4) +
                floor(zeroBasedCent / 4) +
                5 * zeroBasedCent) % 7);
    }
}
