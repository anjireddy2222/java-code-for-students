public class InheritTwo  extends InheritOne {

    public static void main(String[] args) {
        
        InheritTwo obj1 = new InheritTwo();
        obj1.Login();
        obj1.Signup();
        System.out.println( obj1.email );

        // InheritOne -> parent class
        // InheritTwo -> child class

        InheritOne obj2 = new InheritOne();
        

    }

    public void ResetPassword(){
        System.out.println("New password sent to your email");
    }

    
    
}
