public class PayU extends Payments {

    // Please create processPayment
    public static void main(String[] args) {

        PayU objPayU = new PayU();
        objPayU.CreateOrderId();
        objPayU.name();
    }

    public void processPayment(){
        System.out.println("Processing payment for the order " + orderId);
    }

    public void verifyPayments(){
        System.out.println("Verifying payment for the order " + orderId );
    }

    public void name(){
        System.out.println("Name");
    }



    

    
}


