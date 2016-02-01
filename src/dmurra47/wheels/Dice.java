package dmurra47.wheels;

import static dmurra47.wheels.populateNumbersClass.populateNumbers;

/**
 * Specialization of Wheel for the context of rolling dice.
 *
 * @author Darryl Murray
 * @version 1.0, 01-30-2016
 * @see Wheel
 */
public class Dice extends Wheel<Integer> {

    /**
     * Constructor of a Dice wheel.
     */
    public Dice() {
        super(populateNumbers(6));
    }
}
