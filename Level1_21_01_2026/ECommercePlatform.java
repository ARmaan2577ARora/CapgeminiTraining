interface Taxable {
    double calculateTax(double price);

    void getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.18;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax Category: Electronics (18%)");
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax(double price) {
        return price * 0.05;
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax Category: Clothing (5%)");
    }
}

class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void printFinalPrice(Product[] products) {
        for (Product p : products) {
            if (p == null)
                continue;
            p.displayProductInfo();
            double discount = p.calculateDiscount();
            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax(p.getPrice());
                ((Taxable) p).getTaxDetails();
            } else {
                System.out.println("Tax Category: Exempt");
            }
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
        }
    }

    public static void main(String[] args) {
        Product[] inventory = new Product[3];
        inventory[0] = new Electronics("E101", "Laptop", 50000);
        inventory[1] = new Clothing("C201", "T-Shirt", 1000);
        inventory[2] = new Groceries("G301", "Rice", 500);

        System.out.println("--- E-Commerce Platform ---");
        printFinalPrice(inventory);
    }
}
