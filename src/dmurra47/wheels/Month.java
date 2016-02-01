package dmurra47.wheels;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static java.lang.Math.abs;

/**
 * Specialization of Wheel for the context of iterating through months of the year.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see Wheel
 */
public class Month extends Wheel<String> {

    /**
     * Stores the months of the year in order, along with their length.
     */
    private LinkedHashMap<String, Integer> Months;

    /**
     * Default constructor of a Month wheel.
     */
    public Month() {
        super(new ArrayList<>());  // Dummy list to initialize the superclass
        commonConstructorCode();
    }

    /**
     * Constructor for a Month wheel.
     *
     * @param month Specify a month of the year to start at (1-12, inclusive)
     */
    public Month(int month) {
        super(new ArrayList<>());
        commonConstructorCode();

        if (month == 0) {
            month = 1;
        }

        for (int i = 0; i < abs(month - 1) % 12; i++) {
            increase();
        }
    }

    /**
     * Retrieves the length of the current month in days.
     *
     * @return Returns the length of the Month, in days.
     */
    public int getMonthLength() {
        return Months.get(getValue());
    }

    /**
     * Returns the numerical representation of the month (1-12, inclusive)
     *
     * @return Returns the numerical representation of the month (1-12, inclusive)
     */
    public int getMonthNum() {
        int counter = 1;
        for (String txt : Months.keySet()) {
            if (!txt.equals(getValue())) {
                counter++;
            }
            else
                break;
        }
        return counter;
    }

    /**
     * Contains code common to all constructors in this class.
     */
    private void commonConstructorCode() {
        // Initialize Months with proper pairs
        Months = new LinkedHashMap<> ();
        Months.put("Jan", 31);
        Months.put("Feb", 28);
        Months.put("Mar", 31);
        Months.put("Apr", 30);
        Months.put("May", 31);
        Months.put("Jun", 30);
        Months.put("Jul", 31);
        Months.put("Aug", 31);
        Months.put("Sep", 30);
        Months.put("Oct", 31);
        Months.put("Nov", 30);
        Months.put("Dec", 31);

        // Create an ArrayList with the proper values
        ArrayList<String> values = new ArrayList<>();
        for (String txt : Months.keySet())
            values.add(txt);

        super.values = values;  // Replace the dummy list with the real list
    }
}