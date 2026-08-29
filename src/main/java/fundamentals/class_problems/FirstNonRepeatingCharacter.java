package fundamentals.class_problems;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.length() == 0) {
            return '\0';
        }

        int[] count = new int[256];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (count[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void printResult(String text) {
        char ans = findFirstNonRepeatingChar(text);
        if (ans != '\0') {
            System.out.println("First Non-Repeating Character: '" + ans + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        String s1 = "swiss";
        System.out.println("Input: \"" + s1 + "\"");
        printResult(s1);

        String s2 = "aabbcc";
        System.out.println("\nInput: \"" + s2 + "\"");
        printResult(s2);
    }
}
