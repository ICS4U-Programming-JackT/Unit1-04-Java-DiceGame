import java.util.Random;
import java.util.Scanner;

/**
 * Program that plays a number guessing game.
 * The program generates a random number between 1 and 6.
 * User guesses until correct, with hints if the guess
 * is too high or too low. Tracks number of attempts.
 *
 * @author  Jack Turcotte
 * @version 1.0
 * @since   2025-09-24
 */
public final class DiceGame {

    /**
     * Min number for dice roll.*/
    private static final int MIN = 1;
    /**
     * Max number for dice roll.*/
    private static final int MAX = 6;

    /**
     * Private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility Class
     * @see IllegalStateException
     */
    private DiceGame() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Runs the Dice game program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        final Random random = new Random();
        final int target = random.nextInt(MAX - MIN + 1) + MIN;

        final Scanner scanner = new Scanner(System.in);
        int guesses = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I picked a number between "
            + MIN + " and " + MAX + ". Try to guess it!");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            final String input = scanner.nextLine();

            try {
                final int guess = Integer.parseInt(input);
                guesses++;

                if (guess < MIN || guess > MAX) {
                    System.out.println("Your guess must be between "
                        + MIN + " and " + MAX + ".");
                } else if (guess < target) {
                    System.out.println("Too low! Try again.");
                } else if (guess > target) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! The number was "
                        + target + ".");
                    System.out.println("It took you " + guesses
                        + " guess(es).");
                    guessedCorrectly = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number "
                    + "between " + MIN + " and " + MAX + ".");
            }
        }

        scanner.close();
    }
}
