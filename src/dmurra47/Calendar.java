package dmurra47;

import dmurra47.wheels.DateCounter;

import static java.lang.System.out;

/**
 * Calendar iterates through every day of the year.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 */
public class Calendar {

    /**
     * Opening function for the program; arguments are ignored.
     *
     * @param args This parameter is ignored.
     */
    public static void main(String[] args) {
        out.println("Welcome to the dice roller program");

        DateCounter dateCounter;  // The wheel counter that represents the 4 dice


        // Initialize dice with the wheels created earlier
        dateCounter = new DateCounter();
        // Roll the dice, sum the values, add to the counter if > 12, and display the results.
        while (true) {
            out.format(
                    "%s %s %d, %d\n",
                    dateCounter.getWheelValue(3),
                    dateCounter.getWheelValue(1),
                    dateCounter.getWheelValue(0),
                    dateCounter.getWheelValue(2)
            );

            dateCounter.increase();

            // Slow down the output to screen
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
