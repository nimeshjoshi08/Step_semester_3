package fundamentals.assigment_problems;

/**
 * Problem 1: The Exam Hall Seat Duplication Checker
 *
 * Scans an array of assigned seat numbers to detect and flag any duplicate assignments
 * using only arrays and nested loops (no Java Collections framework).
 */
public class ExamHallSeatDuplicationChecker {

    /**
     * Checks an array of seat numbers for duplicates using nested loops and raw arrays.
     *
     * @param seatNumbers Array of seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Seat Numbers Provided");
            return;
        }

        int n = seatNumbers.length;
        boolean[] alreadyReported = new boolean[n];
        boolean duplicateFound = false;

        for (int i = 0; i < n; i++) {
            if (alreadyReported[i]) {
                continue;
            }

            boolean isDuplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDuplicate = true;
                    alreadyReported[j] = true; // Mark subsequent occurrences as reported
                }
            }

            if (isDuplicate) {
                duplicateFound = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Examination Cell - Seat Duplication Checker ===");

        int[] sample1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105} -> Output: ");
        checkDuplicateSeats(sample1);

        int[] sample2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105} -> Output: ");
        checkDuplicateSeats(sample2);

        int[] sample3 = {201, 202, 203, 201, 204, 203};
        System.out.println("\nTesting multiple duplicates {201, 202, 203, 201, 204, 203}:");
        checkDuplicateSeats(sample3);
    }
}
