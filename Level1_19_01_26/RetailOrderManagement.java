package Level1_19_01_26;
class Order{
    int orderID;
    String orderDate;
    Order(int orderID,String orderDate){
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
    void getOrderStatus(){
        System.out.println("Order placed");   
    }
}
class ShippedOrder extends Order{
    int trackingNumber;
    ShippedOrder(int orderID,String orderDate,int trackingNumber){
        super(orderID,orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    void getOrderStatus(){
        System.out.println("Order shipped");
    }
}
class DeliveredOrder extends ShippedOrder{
    int deliveryDate;
    DeliveredOrder(int orderID,String orderDate,int trackingNumber,int deliveryDate){
        super(orderID,orderDate,trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    void getOrderStatus(){
        System.out.println("Order delivered");
    }
}
class RetailOrderManagement {
    public static void main(String[] args) {
        Order o1 = new Order(1,"2026-01-01");
        o1.getOrderStatus();
        ShippedOrder o2 = new ShippedOrder(2,"2026-01-02",123456);
        o2.getOrderStatus();
        DeliveredOrder o3 = new DeliveredOrder(3,"2026-01-03",123456,2026-01-04);
        o3.getOrderStatus();   
    }
}
