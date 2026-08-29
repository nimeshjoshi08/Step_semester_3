package fundamentals.class_problems;

import java.util.Random;
import java.util.Scanner;

/**
 * Problem 1: Rock-Paper-Scissors Game
 *
 * Simulates a multi-round Rock-Paper-Scissors match between the player and the computer.
 * Computes round outcomes, displays a formatted summary table, and reports overall statistics.
 */
public class RockPaperScissors {

    public static final String ROCK = "Rock";
    public static final String PAPER = "Paper";
    public static final String SCISSORS = "Scissors";

    private static final String[] VALID_MOVES = {ROCK, PAPER, SCISSORS};

    /**
     * Determines the outcome of a single round of Rock-Paper-Scissors.
     *
     * @param playerMove   The player's choice ("Rock", "Paper", "Scissors")
     * @param computerMove The computer's choice ("Rock", "Paper", "Scissors")
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        String p = normalizeMove(playerMove);
        String c = normalizeMove(computerMove);

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if ((p.equalsIgnoreCase(ROCK) && c.equalsIgnoreCase(SCISSORS)) ||
            (p.equalsIgnoreCase(PAPER) && c.equalsIgnoreCase(ROCK)) ||
            (p.equalsIgnoreCase(SCISSORS) && c.equalsIgnoreCase(PAPER))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    /**
     * Generates a random move for the computer.
     *
     * @param random Random instance
     * @return "Rock", "Paper", or "Scissors"
     */
    public static String generateComputerMove(Random random) {
        return VALID_MOVES[random.nextInt(VALID_MOVES.length)];
    }

    /**
     * Normalizes case for move strings.
     */
    private static String normalizeMove(String move) {
        String trimmed = move.trim();
        if (trimmed.equalsIgnoreCase(ROCK)) return ROCK;
        if (trimmed.equalsIgnoreCase(PAPER)) return PAPER;
        if (trimmed.equalsIgnoreCase(SCISSORS)) return SCISSORS;
        return trimmed;
    }

    /**
     * Runs a demo simulation with the given player and computer move sequences.
     */
    public static void runSimulation(String[] playerMoves, String[] computerMoves) {
        int rounds = playerMoves.length;
        String[] results = new String[rounds];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s | %-15s | %-15s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            String pMove = normalizeMove(playerMoves[i]);
            String cMove = normalizeMove(computerMoves[i]);
            String result = playRound(pMove, cMove);
            results[i] = result;

            if ("Player Wins".equals(result)) {
                wins++;
            } else if ("Computer Wins".equals(result)) {
                losses++;
            } else if ("Draw".equals(result)) {
                draws++;
            }

            System.out.printf("Round %-4d | %-15s | %-15s | %-15s%n", (i + 1), pMove, cMove, result);
        }

        System.out.println("------------------------------------------------------------------");
        double winPercentage = (rounds > 0) ? ((double) wins / rounds) * 100.0 : 0.0;
        System.out.printf("Final Summary (after %d rounds)%n", rounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
        System.out.println("------------------------------------------------------------------\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Rock-Paper-Scissors Game Demo ===");

        // Sample input demonstration from specification
        String[] demoPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Scissors"};
        String[] demoComputerMoves = {"Scissors", "Paper", "Rock", "Rock", "Paper"};

        System.out.println("\nRunning Predefined 5-Round Match:");
        runSimulation(demoPlayerMoves, demoComputerMoves);

        // Randomized 5-round simulation
        System.out.println("Running Randomized 5-Round Match:");
        Random random = new Random();
        String[] randomPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] randomComputerMoves = new String[5];
        for (int i = 0; i < 5; i++) {
            randomComputerMoves[i] = generateComputerMove(random);
        }
        runSimulation(randomPlayerMoves, randomComputerMoves);
    }
}
