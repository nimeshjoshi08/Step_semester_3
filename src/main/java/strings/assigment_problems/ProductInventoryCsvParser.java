package strings.assigment_problems;

public class ProductInventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String product = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        if (product.isEmpty() || sku.isEmpty() || qty.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + qty);
    }

    public static void main(String[] args) {
        String record1 = "Wireless Mouse,WM-2201,150";
        parseInventoryRecord(record1);

        String record2 = "Wireless Mouse,150";
        parseInventoryRecord(record2);
    }
}
