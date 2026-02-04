import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", name, category.getCategoryName(), price);
    }
}

public class OnlineMarketplace {

    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
        System.out.println("Discount applied to " + product.getName() + ". New price: " + newPrice);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Generics Mastery", 45.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Teal Denim Shirt", 29.99, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone X1", 799.0, new GadgetCategory());

        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("Product Catalog:");
        for (Product<? extends Category> p : catalog) {
            System.out.println(p);
        }

        System.out.println("\nProcessing Discounts:");
        applyDiscount(book, 10);
        applyDiscount(shirt, 20);

        System.out.println("\nUpdated Catalog:");
        for (Product<? extends Category> p : catalog) {
            System.out.println(p);
        }
    }
}
