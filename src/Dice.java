package SnakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Dice {
    private final int numberOfDice;

    public Dice(int numberOfDice) {
        if (numberOfDice <= 0) {
            throw new IllegalArgumentException("Number of dice must be a positive integer.");
        }
        this.numberOfDice = numberOfDice;
    }

    public int rollDice() {
        return ((int) (Math.random() * (6 * numberOfDice - numberOfDice + 1))) + numberOfDice;
    }
}
