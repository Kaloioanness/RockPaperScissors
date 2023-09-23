package SoftUni.RockPaperScissorsByHaru;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerScore = 0;
        int computerScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Player Score: " + playerScore);
            System.out.println("Computer Score: " + computerScore);

            int[] scores = playGame(scanner);
            playerScore += scores[0];
            computerScore += scores[1];

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainChoice = scanner.nextLine().toLowerCase();
            playAgain = playAgainChoice.equals("y");
        }

        System.out.println("Thanks for playing!");
    }

    private static int[] playGame(Scanner scanner) {
        System.out.print("Choose [r]ock, [p]aper, or [s]cissors: ");
        String playerMove = scanner.nextLine().toLowerCase();
        String playerChoice;

        switch (playerMove) {
            case "r":
            case "rock":
                playerChoice = ROCK;
                break;
            case "p":
            case "paper":
                playerChoice = PAPER;
                break;
            case "s":
            case "scissors":
                playerChoice = SCISSORS;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                return new int[]{0, 0};
        }

        Random random = new Random();
        int computerRandomNumber = random.nextInt(3);
        String computerMove;

        switch (computerRandomNumber) {
            case 0:
                computerMove = ROCK;
                break;
            case 1:
                computerMove = PAPER;
                break;
            case 2:
                computerMove = SCISSORS;
                break;
            default:
                computerMove = "";
                break;
        }

        System.out.println("The computer chose " + computerMove);

        String winner = determineWinner(playerChoice, computerMove);
        System.out.println(winner);

        if (winner.equals("You win.")) {
            return new int[]{1, 0};
        } else if (winner.equals("You lose.")) {
            return new int[]{0, 1};
        } else {
            return new int[]{0, 0};
        }
    }

    private static String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "This game was a draw";
        } else if (
                (playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) ||
                        (playerMove.equals(PAPER) && computerMove.equals(ROCK)) ||
                        (playerMove.equals(SCISSORS) && computerMove.equals(PAPER))
        ) {
            return "You win.";
        } else {
            return "You lose.";
        }
    }
}
