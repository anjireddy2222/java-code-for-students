public class ForLoopTwo {

    public static void main(String[] args) {
        
        int[] prices = { 20000, 30000 };

        // 3 items -> 0, 1, 2
        // 4 items -> 0, 1, 2, 3

        for( int i = prices.length - 1  ; i >= 0; i-- ){
            System.out.println( prices[i] );
            // 2 >= 0 -> true -> prices[2]
            // 1 >= 0 -> true -> prices[1]
            // 0 >= 0 -> true -> prices[0]
            // -1 >= 0 -> true 
        }


    }
    
}
