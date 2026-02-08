package java8problem.level1folder;

import java.util.*;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}

class ProductSales {
    String productId;
    double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String getProductId() { return productId; }
    public double getTotalRevenue() { return totalRevenue; }

    @Override
    public String toString() {
        return "ProductSales{productId='" + productId + "', totalRevenue=" + totalRevenue + "}";
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P001", 15, 100.0),
            new Sale("P002", 5, 200.0),
            new Sale("P003", 20, 50.0),
            new Sale("P001", 12, 110.0),
            new Sale("P004", 30, 20.0),
            new Sale("P005", 8, 500.0),
            new Sale("P006", 25, 40.0)
        );

        processSales(sales);
    }

    public static void processSales(List<Sale> sales) {
        // 1. Filter: quantity > 10
        // 2. Transform: Create ProductSales objects (productId and total revenue)
        // 3. Sort: Sort by total revenue descending
        // 4. Top N: Top 5 products
        List<ProductSales> top5Products = sales.stream()
            .filter(s -> s.getQuantity() > 10)
            .map(s -> new ProductSales(s.getProductId(), s.getQuantity() * s.getPrice()))
            .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
            .limit(5)
            .collect(Collectors.toList());

        System.out.println("Top 5 Products by Total Revenue (Quantity > 10):");
        top5Products.forEach(System.out::println);
    }
}
