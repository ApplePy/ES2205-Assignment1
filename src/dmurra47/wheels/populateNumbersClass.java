package dmurra47.wheels;

import java.util.ArrayList;

/**
 * Helper class to ease generation of lists of numbers.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see ArrayList
 */
class populateNumbersClass {

    /**
     * Generates an ArrayList of Integers from 1 - num (inclusive).
     *
     * @param num The maximum number in the generated ArrayList.
     * @return Returns an array of numbers from 1-num (inclusive).
     */
    static ArrayList<Integer> populateNumbers(int num) {

        // Create an ArrayList with the proper values
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= num; i++)
            values.add(i);

        return values;
    }
}
