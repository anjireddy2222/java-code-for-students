
public class Payments {

    
    public int orderId = 0;

    public void CreateOrderId(){
        orderId = 25;
        System.out.println("Payments: order id created " + orderId + " " + ProductCategory.COMPUTERS);
    }

    public void Refund(){
        orderId = 255;
        System.out.println("Payments: Refund initiated for order id " + orderId);
    }

    protected void CancelOrder(){
        CreateOrderId();
        System.out.println("Payments: your order with id " + orderId);
    }

    // public abstract void processPayment();

    // public abstract void verifyPayments();



    // create
    // status check
    // cancel
    // refund
    // 


}



