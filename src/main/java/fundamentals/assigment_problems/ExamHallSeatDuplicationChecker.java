package fundamentals.assigment_problems;

public class ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        int n = seatNumbers.length;
        boolean[] seen = new boolean[n];
        boolean hasDuplicate = false;

        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }

            boolean duplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    duplicate = true;
                    seen[j] = true;
                }
            }

            if (duplicate) {
                hasDuplicate = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] input1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(input1);

        int[] input2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(input2);
    }
}
