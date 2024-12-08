public class ProductsHandler {

    // get product details
    // quantity 
    // payment 
    public static void main(String[] args) {
        ProductsHandler ph = new ProductsHandler();
        ph.getProductDetails(125);
        ph.processPayment(0, 0, 150);
    }

    public void getProductDetails(int productId){
        // 100 -> 1 to 100
        // 120

        try{
            if( productId > 100){
                throw new ProductExceptions("Invalid product Id. ");
            }else{
                System.out.println("Found product details");
            }
        }catch(ProductExceptions ex){
            System.out.println( ex.getMessage());
        }
        

    }

    public void checkInventory(int qunatity){
        // 10

    }

    public void processPayment(int productId, int qunatity, int price){
        try{

            if( price < 100){
                System.out.println("Payment successful");
            }else{
                throw new PaymentExceptions("Invalid CVV");
            }

        }catch(PaymentExceptions ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
