import java.util.ArrayList;
import java.util.LinkedList;

public class ArraysOne {


    public static void main(String[] args) {
        
        // ArrayList
        ArrayList<String> users = new ArrayList<String>();
        System.out.println( users.size() );

        users.add("Anji"); // 0
        System.out.println( users.size() );

        users.add("DD"); // 1
        System.out.println( users.size() );

        // index -> 0, 1
        System.out.println( users.get(0) );
        System.out.println( users.get(1) );

        System.out.println( users.size() );
        users.remove(0);
        System.out.println( users.size() );
        // index -> 0
        System.out.println( users.get(0));

        // 0 -> number of items -> loop
        // 3 items -> 0, 1, 2 -> 
        users.add("ReactJS");
        users.add("Java");
        for(int i = 0; i < users.size(); i++  ){
            System.out.println( users.get(i) );
        }

        // LinkedList
        System.out.println("#########################################################################");
        LinkedList<String> titles = new LinkedList<String>();
        System.out.println( titles.size() );

        titles.add("ReactJS tutorial");
        titles.add("Spring boot tutorial");
        System.out.println( titles.size() );

        System.out.println( titles.get(0));
        titles.set(0, "MySQL tutorial");

        System.out.println( titles.get(0));

        titles.remove(0);
        System.out.println( titles.get(0));
        








    }
    
}
