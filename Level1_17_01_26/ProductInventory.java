package Level1_17_01_26;

class Product{
    String  productName;
    int price;
    static int totalProducts;

    Product(String product,int price){
        this.productName = product;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails(){
        System.out.println(this.productName);
        System.out.println(this.price);
    }

    static void displayTotalProducts(){
        System.out.println(totalProducts);
    }
}
public class ProductInventory {
    public static void main(String[] args) {
        Product p1 = new Product("charger",500);
        Product p2 = new Product("phone",17500);
        Product p3 = new Product("earbud",3500);

        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}
