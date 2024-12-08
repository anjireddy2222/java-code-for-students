public class ForLoop {

    public static void main(String[] args) {
        
        String[] titles = { 
                                "Apple iPhone 14 (Starlight, 128 GB)", "Apple iPhone 14 (Purple, 128 GB)",
                                "Apple iPhone 14 (Midnight, 128 GB)", "Apple iPhone 15 (Blue, 128 GB)"
                        };
        // Index -> 0, 1, 2, 3 -> no of items 4
        System.out.println( titles.length );
        // 3 items -> 0, 1, 2 
        // 4 items -> 0, 1, 2, 3
        // 5 items -> 0, 1, 2, 3, 4
        // no of items - 1
        
        for( int i = 0; i < titles.length;  i++  ){
            // repeated task
            System.out.println( titles[i] );
            // 0 < 4 -> true -> titles[0]
            // 1 < 4 -> true -> titles[1]
            // 2 < 4 -> true -> titles[2]
            // 3 < 4 -> true -> titles[3]
            // 4 < 4 -> false
        }





    }
    
}
