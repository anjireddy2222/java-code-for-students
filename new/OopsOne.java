public class OopsOne {

    String userEmail = "";
    String userPassword = "";

    public OopsOne(String inpEmail, String inpPword){
        // constructor method
        userEmail = inpEmail;
        userPassword = inpPword;
    }


    public static void main(String[] args) {
    
        OopsOne obj1 = new OopsOne("anji@ss.co", "obj1 pword");
        

        OopsOne obj2 = new OopsOne("your email", "obj2 pword");

        System.out.println( obj1.userEmail );
        System.out.println( obj1.userPassword );

        System.out.println( obj2.userEmail );
        System.out.println( obj2.userPassword );

        OopsTwo op2 = new OopsTwo();
        System.out.println( op2.price );

        

    }


    public void Login(){
        System.out.println("Invalid Login credentials");
    } 


    public void Signup(){
        System.out.println("Account created. Please check your email");
    }
    
    public  void ResetPassword(){
        System.out.println("New password sent to your email id");
    }




    
}
