public class ErrorHandling {

    public static void main(String[] args) {
        
        
        try{

            String[] emails = { "contact@softwareschool.co", "wc@softwareschool.co" };

            System.out.println( emails[2] );

        }catch(Exception ex){

            System.out.println( ex.getMessage()  );
            ex.printStackTrace();

        }

        



    }
    
}
