package fundamentals.class_problems;

/**
 * Problem 5: Reverse Customer Name
 *
 * Customer Identity Verification System module that reverses a customer's name
 * for security verification and training exercises without altering the original string.
 */
public class ReverseCustomerName {

    /**
     * Reverses the given customer name.
     *
     * @param customerName The original customer name
     * @return The reversed customer name
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===");

        String[] sampleNames = {"Sunil", "Alice", "John Doe", "AARAV", "Madam"};

        for (String name : sampleNames) {
            String reversed = reverseCustomerName(name);
            System.out.println("Original Name: " + name);
            System.out.println("Reversed Name: " + reversed);
            System.out.println();
        }
    }
}
