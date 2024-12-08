public class IfElse {

    public static void main(String[] args) {
        
        int orderValue = 150;
        int minValue = 300;

        if( orderValue > minValue ){
            System.out.println("10% discount LUCKY10");
        }else{
            int difAmount = minValue - orderValue;
            System.out.println("Add " +  difAmount  + " more to get 10% discount");
        }





    }
    
}
