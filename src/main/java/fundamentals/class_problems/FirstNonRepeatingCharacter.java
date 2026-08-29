package fundamentals.class_problems;

/**
 * Problem 4: First Non-Repeating Character
 *
 * Scans a string, counts character frequencies, and identifies the first character
 * that occurs exactly once.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Finds the first non-repeating character in the given text.
     *
     * @param text The input string
     * @return The first non-repeating character, or '\0' if no such character exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency array for ASCII character set
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256) {
                freq[c]++;
            }
        }

        // Scan string left to right to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256 && freq[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    /**
     * Evaluates and prints the result in the specified format.
     */
    public static void displayFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game ===");

        String[] testCases = {"swiss", "aabbcc", "developer", "stress", "racecar", "step"};
        for (String test : testCases) {
            System.out.printf("Input: \"%s\"%n", test);
            System.out.print("Output: ");
            displayFirstNonRepeatingChar(test);
            System.out.println();
        }
    }
}
