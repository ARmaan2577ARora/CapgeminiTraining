import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added: " + item.getName());
    }

    public List<T> getItems() {
        return items;
    }
}

public class SmartWarehouse {
    
    public static void displayItems(List<? extends WarehouseItem> items) {
        System.out.println("Warehouse Inventory:");
        for (WarehouseItem item : items) {
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> techStorage = new Storage<>();
        techStorage.addItem(new Electronics("Laptop"));
        techStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> foodStorage = new Storage<>();
        foodStorage.addItem(new Groceries("Apple"));
        foodStorage.addItem(new Groceries("Bread"));

        Storage<Furniture> homeStorage = new Storage<>();
        homeStorage.addItem(new Furniture("Chair"));
        homeStorage.addItem(new Furniture("Table"));

        System.out.println();
        displayItems(techStorage.getItems());
        displayItems(foodStorage.getItems());
        displayItems(homeStorage.getItems());

        List<WarehouseItem> mixedItems = new ArrayList<>();
        mixedItems.add(new Electronics("Tablet"));
        mixedItems.add(new Groceries("Milk"));
        mixedItems.add(new Furniture("Sofa"));
        
        System.out.println();
        displayItems(mixedItems);
    }
}
