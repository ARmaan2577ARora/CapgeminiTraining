interface Discountable {
    double applyDiscount(double totalPrice);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.10;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount (10%)";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double serviceCharge = 50.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + serviceCharge;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice > 500 ? totalPrice * 0.05 : 0;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Special Discount (5% on >500)";
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = new FoodItem[2];
        order[0] = new VegItem("Paneer Tikka", 250, 2);
        order[1] = new NonVegItem("Chicken Biryani", 450, 1);

        System.out.println("--- Online Food Delivery System ---");
        for (FoodItem item : order) {
            if (item != null) {
                item.getItemDetails();
                double subtotal = item.calculateTotalPrice();
                System.out.println("Subtotal (incl. charges if any): " + subtotal);
                if (item instanceof Discountable) {
                    Discountable d = (Discountable) item;
                    double discount = d.applyDiscount(subtotal);
                    System.out.println("Discount applied (" + d.getDiscountDetails() + "): " + discount);
                    System.out.println("Final Total: " + (subtotal - discount));
                } else {
                    System.out.println("Final Total: " + subtotal);
                }
            }
        }
    }
}
