package strings.assigment_problems;

public class AtmPinLengthValidator {

    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        String pin1 = "482";
        System.out.print("Input: \"" + pin1 + "\" -> ");
        checkPinLength(pin1);

        String pin2 = "4820";
        System.out.print("Input: \"" + pin2 + "\" -> ");
        checkPinLength(pin2);
    }
}
