public class Comparision {

    public static void  main(String[] args){

        String dbEMail = "contact@softwareschool.co";
        String dbPassword = "abcd1234";

        String userEmail = "contact@softwareschool.co";
        String userPassword = "abcd1234";

        System.out.println( dbEMail == userEmail ); // true

        userEmail = "contact@softwareschool.com";
        System.out.println( dbEMail == userEmail ); // false

        System.out.println( dbPassword == userPassword );
        userPassword = "bacdferada";
        System.out.println( dbPassword == userPassword );
        // == -> 
        int adminId = 10;
        int loggedInUserId = 10;

        System.out.println( adminId == loggedInUserId );

        // 
        System.out.println( adminId != loggedInUserId );  // true, false

        int viewingProfileId = 5;

        System.out.println( loggedInUserId == viewingProfileId );

        System.out.println( loggedInUserId != viewingProfileId ); // follow, unfollow


        int billTotal = 200;
        int minAmout = 300;

        System.out.println( billTotal > minAmout );
        billTotal = 200 + 101;
        System.out.println( billTotal >= minAmout );
        billTotal = 200;
        System.out.println( billTotal < minAmout );






    }
    
}
