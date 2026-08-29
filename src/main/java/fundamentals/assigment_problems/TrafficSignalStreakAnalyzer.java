package fundamentals.assigment_problems;

/**
 * Problem 3: The Traffic Signal Streak Analyzer
 *
 * Scans continuous signal reading logs (e.g., 'R', 'Y', 'G') and discovers the longest
 * continuous streak of any color to identify potentially malfunctioning or stuck traffic signals.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Scans through the signal log string and prints the color and length of the longest streak.
     *
     * @param signalLog String of consecutive signal state characters (e.g., "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No Signal Readings Found");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = c;
                currentStreak = 1;
            }
        }

        // Check the final streak
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("=== Traffic Signal Streak Analyzer ===");

        String test1 = "RRGGGYRR";
        System.out.printf("Input: \"%s\" -> Output: ", test1);
        findLongestStreak(test1);

        String test2 = "RRRRYYGG";
        System.out.printf("Input: \"%s\" -> Output: ", test2);
        findLongestStreak(test2);

        String test3 = "GYRRRGGGGYY";
        System.out.printf("Input: \"%s\" -> Output: ", test3);
        findLongestStreak(test3);
    }
}
