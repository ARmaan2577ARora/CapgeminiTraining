package level1_15_01_26;
class Item {
    int itemCode;
    String itemName;
    double price;
    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Item: " + price);
    }
    void calculateTotalCost(int quantity) {
        double total = price * quantity;
        System.out.println("Total Cost for " + quantity + " items: " + total);
    }
    public static void main(String[] args) {
        Item item = new Item();
        item.itemCode = 203;
        item.itemName = "Sharpener";
        item.price = 10.00;
        item.displayDetails();
        item.calculateTotalCost(5);
    }
}
