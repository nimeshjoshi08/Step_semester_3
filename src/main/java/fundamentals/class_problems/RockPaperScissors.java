package fundamentals.class_problems;

import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }

        String p = playerMove.trim();
        String c = computerMove.trim();

        if (p.equalsIgnoreCase(c)) {
            return "Draw";
        }

        if ((p.equalsIgnoreCase("Rock") && c.equalsIgnoreCase("Scissors")) ||
            (p.equalsIgnoreCase("Paper") && c.equalsIgnoreCase("Rock")) ||
            (p.equalsIgnoreCase("Scissors") && c.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void runMatch(String[] playerMoves, String[] computerMoves) {
        int rounds = playerMoves.length;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            String result = playRound(playerMoves[i], computerMoves[i]);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else if (result.equals("Draw")) {
                draws++;
            }

            System.out.println("Round " + (i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + result);
        }

        double winPercentage = (rounds > 0) ? ((double) wins / rounds) * 100.0 : 0.0;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Scissors"};
        String[] computerMoves = {"Scissors", "Paper", "Rock", "Rock", "Paper"};

        runMatch(playerMoves, computerMoves);
    }
}
