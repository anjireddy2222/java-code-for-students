public class Emailer {

    public static void main(String[] args) {
        // Email -> max 2 seconds
        // SendGrid
        // AWS SES
        // Flipkart -> password reset email (subject, body, to email) -> our server -> 
        // SendGrid (secret keys) -> contact@softwareschool.co -> their server 
        // 2 seconds
        // 200ms 

        // Email
        // database check -> sql
        // send password reset email -> 2 seconds
        // ok response
        // error message

        System.out.println("Email received");
        System.out.println("Check db -> sql query");

        SendGridEmailer sGridEmailer = new SendGridEmailer();

        Thread tdObj = new Thread(sGridEmailer);
        tdObj.start();
        
        System.out.println("Please check your email.");




    }
    
}
