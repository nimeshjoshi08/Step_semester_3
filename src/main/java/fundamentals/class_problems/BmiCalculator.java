package fundamentals.class_problems;

/**
 * Problem 3: BMI Calculator for a Team
 *
 * Processes employee heights and weights, calculates BMI values,
 * categorizes health status, and produces a structured wellness report table.
 */
public class BmiCalculator {

    /**
     * Categorizes health status based on Body Mass Index (BMI).
     *
     * @param bmi Calculated Body Mass Index
     * @return Status description: "Underweight", "Normal", "Overweight", or "Obese"
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI from weight and height.
     *
     * @param height Height in meters
     * @param weight Weight in kilograms
     * @return Calculated BMI value
     */
    public static double calculateBmi(double height, double weight) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return weight / (height * height);
    }

    /**
     * Generates and prints a complete wellness report for a team.
     *
     * @param heights Array of heights in meters
     * @param weights Array of weights in kilograms
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid input: Heights and weights arrays must be non-null and of equal length.");
            return;
        }

        System.out.println("==========================================================================");
        System.out.printf("%-12s | %-12s | %-12s | %-10s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("==========================================================================");

        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = calculateBmi(height, weight);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-5d | %-12.2f | %-12.2f | %-10.2f | %-12s%n",
                    (i + 1), height, weight, bmi, status);
        }
        System.out.println("==========================================================================\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Corporate Wellness Program - BMI Report ===");

        // Sample input dataset
        double[] sampleHeights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.90};
        double[] sampleWeights = {70.0, 90.0, 62.0, 85.0, 68.0, 42.0, 95.0, 58.0, 74.0, 110.0};

        printWellnessReport(sampleHeights, sampleWeights);
    }
}
