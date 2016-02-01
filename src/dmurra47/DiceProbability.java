package dmurra47;

import dmurra47.wheels.Dice;
import dmurra47.wheels.Rollable;
import dmurra47.wheels.WheelCounter;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * DiceProbability iterates through every combination of 4 die, outputting the sum of the roll and how
 * many sums were above 12 as a number and a probability.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 */
public class DiceProbability {

    /**
     * Opening function for the DiceProbability program; arguments are ignored.
     *
     * @param args This parameter is ignored.
     */
    public static void main(String[] args) {

        out.println("Welcome to the dice roller program");

        ArrayList<Rollable<Integer>> wheels = new ArrayList<>();    // Array of wheels for the wheel counter
        WheelCounter<Integer> dice = null;                 // The wheel counter that represents the 4 dice
        double counter = 0;                    // Counts the sums that were above 12

        // Make wheels with valid values
        for (int i = 0; i < 4; i++) {
            wheels.add(new Dice());  // Polymorphism!
        }

        // Initialize dice with the wheels created earlier
        dice = new WheelCounter<>(wheels);

        // Roll the dice, sum the values, add to the counter if > 12, and display the results.
        for (int i = 0; i < 1296; i++, dice.increase()) {
            int sum = dice.getWheelValue(3) +
                    dice.getWheelValue(2) +
                    dice.getWheelValue(1) +
                    dice.getWheelValue(0);

            if (sum > 12)
                ++counter;

            out.format(
                    "for %d%d%d%d the sum was %d\n",
                    dice.getWheelValue(3),
                    dice.getWheelValue(2),
                    dice.getWheelValue(1),
                    dice.getWheelValue(0),
                    sum
            );
        }

        // Output some statistics
        out.format("The number of rolls out of 1296 that were greater than 12 was %d\n", (int) counter);
        out.format("The probability is %f\n", counter / 1296);
    }
}
