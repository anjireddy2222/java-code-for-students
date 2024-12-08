public class WhileLoop {

    public static void main(String[] args) {
        
        String[] emails = { "ar@ss.co", "wc@ss.co", "contact@ss.co" };

        boolean isEmailSent = false;

        int index = 0;

        while(  isEmailSent == false ){
            System.err.println(index);
            if( emails[index] == "contact@ss.co" ){
                // send email
                System.out.println("Email sent to " + emails[index] );
                isEmailSent = true;
            }
            index += 1;

        }








    }
    
}
