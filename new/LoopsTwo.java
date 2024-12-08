public class LoopsTwo {

    public static void main(String[] args) {
        
        int[] prices = { 20000, 33000, 25000, 40000 };
        // 4 items -> 0, 1, 2, 3
        // for( int i = 0; i < prices.length; i++ ){
        //     System.out.println( prices[i] );
        //     if( prices[i] == 25000 ){
        //         break;
        //     }
        //     // 0 < 4 -> true -> prices[0] -> 20000
        //     // 1 < 4 -> true -> prices[1] -> 33000
        //     // 2 < 4 -> true -> prices[2] -> 25000
    
        // }

        for( int  i =0; i < prices.length; i++ ){
            if( prices[i] == 25000 ){
                continue;
            }
            System.out.println( prices[i] );
            // 0 < 4 -> true -> prices[0] -> 20000
            // 1 < 4 -> true -> prices[1] -> 33000
            // 2 < 4 -> true -> 
            // 3 < 4 -> true -> prices[3] -> 40000
            // 4 < 4 -> false
        }







    }
    
}
