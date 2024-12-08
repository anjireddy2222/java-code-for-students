public class OopsTwo {

    String title = "";
    int price = 0;

    

    public static void main(String[] args) {
        

        OopsTwo obj1 = new OopsTwo();
        OopsTwo obj2 = new OopsTwo();

        System.out.println( obj1.title + " : " + obj1.price);
        System.out.println( obj2.title + " : " + obj2.price);

        obj1.Login();
        obj2.Login();

    }

    public void Login() {
    
        System.out.println( title );
    }

    
}
