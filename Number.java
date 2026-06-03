
import java.util.Scanner;
import java.util.Random;
public class Number {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!\n" +
                "I'm thinking of a number between 1 and 100.");
        int chances = difficulty();
        System.out.println("You have " + chances + " chances");
        playGame(chances);
        while (true) {
            sc.nextLine();
            System.out.println("Do you want to play again? (yes or no): ");
            String play = sc.nextLine();
            if (play.equalsIgnoreCase("yes") || play.equalsIgnoreCase("y")) {
                int chance = difficulty();
                playGame(chance);
            } else {
                System.out.println("Thanks you for playing!");
                System.exit(0);
            }
        }
    }
    static int difficulty() {
        System.out.println("Please select difficulty!");
        System.out.println("1.Easy (10 Chances)");
        System.out.println("2.Normal (5 Chances)");
        System.out.println("3.Hard (3 Chances)");
        System.out.print("Choose mode(1.Easy/ 2.normal/ 3.hard): ");
        int choice = sc.nextInt();
        sc.nextLine();
        return switch (choice) {
            case 1 -> 10;
            case 2 -> 5;
            case 3 -> 3;
            default -> {
                System.out.println("Invalid choice automatically goes to normal mode");
                yield 5;
            }
        };
    }
    static void playGame(int chances){
        int guess;
        int secretNumber = random.nextInt(100) + 1;

        for(int attempt = 1; attempt<=chances; attempt++) {
            System.out.print("Enter your guess : ");
            guess = sc.nextInt();

            if(guess < 1 || guess > 100){
                System.out.println("Invalid guess!");
                attempt--;
                continue;
            }
            if (guess == secretNumber) {
                System.out.println("Correct! The secret number was " + secretNumber + " you guessed with " + attempt + " attempts");
                System.out.println("You have "+(chances - attempt) + " lefts");
                return;
            } else if (guess > secretNumber) {
                System.out.println("Incorrect! Number is lower than " + guess);
            } else {
                System.out.println("Incorrect! Number is greater than " + guess);
            }
        }
        System.out.println("Game over! The secret number was " + secretNumber + " !");
    }
}