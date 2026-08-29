package fundamentals.assigment_problems;

/**
 * Problem 5: The Movie Review Word Length Profiler
 *
 * Moderation tool that analyzes word-length distributions across movie reviews
 * to detect potential spam or bot activity by classifying words into Short, Medium, and Long.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits the review into words and prints counts of Short (1-4), Medium (5-8), and Long (9+) words.
     *
     * @param review The review text string
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String rawWord : words) {
            // Strip any surrounding punctuation to get clean word length
            String cleanWord = rawWord.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");
            int len = cleanWord.isEmpty() ? rawWord.length() : cleanWord.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=== Movie Review Word Length Profiler ===");

        String review1 = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review1 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review1);

        System.out.println();
        String review2 = "An outstanding, breathtaking cinematic masterpiece with extraordinary performances";
        System.out.println("Input: \"" + review2 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review2);
    }
}
