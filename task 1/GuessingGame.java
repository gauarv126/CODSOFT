import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            playRound(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            String userInput = scanner.next();

            if (!userInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);
        scanner.close();
    }

    private static void playRound(Scanner scanner) {
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 5;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("I have generated a random number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
        }
    }
}
