package strings.class_problems;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6));

        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "9876543210";
        System.out.println("Input: \"" + num1 + "\" -> Output: " + maskPhoneNumber(num1));

        String num2 = "98765";
        System.out.println("Input: \"" + num2 + "\" -> Output: " + maskPhoneNumber(num2));

        String num3 = "98765abcd0";
        System.out.println("Input: \"" + num3 + "\" -> Output: " + maskPhoneNumber(num3));
    }
}
