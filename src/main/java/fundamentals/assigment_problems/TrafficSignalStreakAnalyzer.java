package fundamentals.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            return;
        }

        char bestColor = signalLog.charAt(0);
        int maxCount = 1;

        char currentColor = signalLog.charAt(0);
        int currentCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    bestColor = currentColor;
                }
                currentColor = c;
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            bestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", bestColor, maxCount);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
