package Level1_22_01_2026;
import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;
    String id;

    public Product(String name, double price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Order {
    String orderId;
    List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (Product p : products) {
            System.out.println("- " + p);
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

class Customer {
    String name;
    String customerId;
    List<Order> orders;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Customer " + name + " placed a new order (" + order.orderId + ").");
    }

    public void showHistory() {
        System.out.println("--- Order History for " + name + " ---");
        for (Order o : orders) {
            o.displayOrder();
            System.out.println();
        }
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Customer alice = new Customer("Alice Johnson", "C001");

        Product phone = new Product("Smartphone", 799.99, "P101");
        Product case1 = new Product("Phone Case", 19.99, "P102");
        Product charger = new Product("Fast Charger", 25.49, "P103");

        Order order1 = new Order("ORD-505");
        order1.addProduct(phone);
        order1.addProduct(case1);

        Order order2 = new Order("ORD-506");
        order2.addProduct(charger);

        alice.placeOrder(order1);
        alice.placeOrder(order2);

        System.out.println();
        alice.showHistory();
    }
}
