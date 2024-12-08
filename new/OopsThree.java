public class OopsThree extends OopsFour {

    public static void main(String[] args) {

        // 2, 3 => 2 + 3 => 5
        // 2, 3, 4 => 2 + 3 + 4 => 9
        // 2, 3, 4, 5 => 2 + 3 + 4+ 5 => 14

        OopsThree obj1 = new OopsThree();
        obj1.add(2, 3);
        obj1.add(25, 32);

        obj1.add( "Java", "oops");

        obj1.add(1, 2, 3); // method over loading

        OopsFour obj2 = new OopsFour();
        obj2.add(10, 11);
 
    }

    
    @Override
    public void add(int a, int b){
        System.out.println(a + b );
    }

    public void add(String x, String y){
        System.out.println( x + y);
    }

    public void add(int a, int b, int c){
        System.out.println( a + b + c);
    }










    
}
