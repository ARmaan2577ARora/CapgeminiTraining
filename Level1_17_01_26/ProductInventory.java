package Level1_16_01_26;

class Product{
    String  productName;
    int price;

    static int  totalProducts;

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
        Product p1 = new Product("charger",100);
        Product p2 = new Product("phone",10000);
        Product p3 = new Product("earbud",1000);

        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();


    }
}
