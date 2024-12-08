public class Paytm extends Payments {

    public static void main(String[] args) {

        Paytm obj1 = new Paytm();
        obj1.orderId = 30;

        obj1.CancelOrder();

    }
    public void processPayment(){
        System.out.println("Processing payment for the order " + orderId);
    }

    public void verifyPayments(){
        System.out.println("verifying payment for the order " + orderId);
    }
    
   
    
}


