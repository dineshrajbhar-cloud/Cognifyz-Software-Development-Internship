import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("<=========Let's Have Fun========>");
        System.out.println("<=========NUMBER GUESSING GAME==========>");
        System.out.println("<===========👾👾👾===========>");

        String playAgain;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("Try to guess it!");

            while (!guessedCorrectly) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }
                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }
                attempts++;

                if (guess > secretNumber) {
                    System.out.println("Too High! Try again.");

                } else if (guess < secretNumber) {
                    System.out.println("Too Low! Try again.");

                } else {
                    System.out.println("\nCorrect!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    guessedCorrectly = true;
                }
            }

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("\nThank you for playing!");
        System.out.println("Game ended.");

        scanner.close();
    }
}