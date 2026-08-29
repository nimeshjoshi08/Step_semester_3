package fundamentals.assigment_problems;

/**
 * Problem 2: The Typing Speed Test Accuracy Checker
 *
 * Compares an original passage against user-typed text character by character,
 * computing accuracy percentage and pinpointing the first mismatch position.
 */
public class TypingSpeedTestAccuracyChecker {

    /**
     * Compares original and typed strings and prints detailed accuracy diagnostics.
     *
     * @param original The reference passage string
     * @param typed    The user's typed string
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: Strings cannot be null.");
            return;
        }

        int totalChars = original.length();
        if (totalChars == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPos = -1;
        char origMismatchChar = '\0';
        char typedMismatchChar = '\0';

        int compareLen = Math.min(original.length(), typed.length());

        for (int i = 0; i < compareLen; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedCount++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-indexed position
                origMismatchChar = origChar;
                typedMismatchChar = typedChar;
            }
        }

        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = compareLen + 1;
        }

        double accuracy = ((double) matchedCount / totalChars) * 100.0;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedCount, totalChars, accuracy));

        if (firstMismatchPos == -1) {
            sb.append("No Mismatches");
        } else {
            sb.append(String.format("First Mismatch at position %d ('%c' vs '%c')",
                    firstMismatchPos, origMismatchChar, typedMismatchChar));
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("=== Typing Speed Test Accuracy Checker ===");

        System.out.println("Test Case 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest Case 2:");
        checkTypingAccuracy("coding", "coding");

        System.out.println("\nTest Case 3:");
        checkTypingAccuracy("Java Programming", "Java Programxong");
    }
}
