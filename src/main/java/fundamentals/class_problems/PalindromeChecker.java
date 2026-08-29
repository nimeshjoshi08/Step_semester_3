package fundamentals.class_problems;

public class PalindromeChecker {

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

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return checkRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] arr = text.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != rev[i]) {
                return false;
            }
        }
        return true;
    }

    public static void checkAndPrint(String text) {
        String iter = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String rec = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String rev = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iter + " | Recursive: " + rec + " | Array Reversal: " + rev);
    }

    public static void main(String[] args) {
        String test1 = "madam";
        System.out.println("Input: \"" + test1 + "\"");
        checkAndPrint(test1);

        String test2 = "hello";
        System.out.println("\nInput: \"" + test2 + "\"");
        checkAndPrint(test2);
    }
}
