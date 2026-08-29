package fundamentals.class_problems;

/**
 * Problem 2: Palindrome Checker (3 Approaches)
 *
 * Implements and compares three independent palindrome detection algorithms:
 * 1. Iterative two-pointer comparison
 * 2. Recursive divide-and-conquer comparison
 * 3. Character array reversal and comparison
 */
public class PalindromeChecker {

    /**
     * Approach 1: Iterative check comparing characters from both ends moving inward.
     *
     * @param text The input string to check
     * @return true if text is a palindrome, false otherwise
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check comparing first and last characters.
     *
     * @param text The input string to check
     * @return true if text is a palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursiveHelper(text, start + 1, end - 1);
    }

    /**
     * Approach 3: Array-reversal check converting string to char array, reversing it, and comparing.
     *
     * @param text The input string to check
     * @return true if text is a palindrome, false otherwise
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Utility method to format the 3-way check result string.
     */
    public static String evaluateAllApproaches(String text) {
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        String iterStr = iterative ? "Palindrome" : "Not Palindrome";
        String recStr = recursive ? "Palindrome" : "Not Palindrome";
        String arrStr = arrayReversal ? "Palindrome" : "Not Palindrome";

        return String.format("Iterative: %s | Recursive: %s | Array Reversal: %s", iterStr, recStr, arrStr);
    }

    public static void main(String[] args) {
        System.out.println("=== Palindrome Checker (3 Approaches) ===");

        String[] testCases = {"madam", "hello", "racecar", "step", "noon", "radar"};
        for (String test : testCases) {
            System.out.printf("Input: \"%s\"%n", test);
            System.out.println("Output: " + evaluateAllApproaches(test));
            System.out.println();
        }
    }
}
