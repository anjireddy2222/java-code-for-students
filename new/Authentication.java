
public class Authentication{

    public static void main(String[] args){
        
        System.out.println("hello word... java");

        Authentication authObj = new Authentication();
        authObj.Login(); 

        authObj.CreateAccount();

        authObj.ResetPassword();

        Cart cartOBj = new Cart();
        cartOBj.AddTocart();

    }

    public void Login(){
        System.out.println("Login success");
    }

    public void CreateAccount(){
        System.out.println("Account created");
    }

    public void ResetPassword(){
        System.out.println("ResetPassword");
    }


}








