package fundamentals.assigment_problems;

/**
 * Problem 4: The Warehouse Inventory Balancer
 *
 * Compares stock counts across warehouse storage sections A and B to verify balance
 * and locate the peak inventory item across sections.
 */
public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory across two sections, computing totals, checking balance status,
     * and locating the single highest quantity item.
     *
     * @param sectionA Item quantities in Section A
     * @param sectionB Item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid input: Inventory arrays cannot be null.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxItemIndex = 1;

        int len = Math.min(sectionA.length, sectionB.length);

        // Scan Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1; // 1-indexed item number
            }
        }

        // Scan Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1; // 1-indexed item number
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQuantity, maxSection, maxItemIndex);
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory Balancer ===");

        int[] sectionA1 = {20, 15, 30};
        int[] sectionB1 = {25, 10, 30};
        System.out.println("Test Case 1:");
        analyzeInventory(sectionA1, sectionB1);

        int[] sectionA2 = {40, 20, 15, 50};
        int[] sectionB2 = {30, 25, 20, 60};
        System.out.println("\nTest Case 2:");
        analyzeInventory(sectionA2, sectionB2);
    }
}
