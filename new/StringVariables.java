public class StringVariables {
    
    public static void main(String[] args) {
        
        String userName = "An";
        System.out.println( userName.length() );

        String userPassword = "abcd1234#@";

        System.out.println( userPassword.length() );

        // #, @ 
        System.out.println( userPassword.contains("@")  );

        String userEmail = "   concat@softwareschool.co    ";
        System.out.println(userEmail);
        System.out.println( userEmail.length() );
        userEmail = userEmail.trim();
        System.out.println(userEmail);
        System.out.println( userEmail.length() );

        String firstName = "Anji";
        String lastName = "Reddy";
        System.out.println( firstName + " " + lastName );
        String fullname = firstName + " " + lastName + " Akkala";
        System.out.println( fullname );

        // FEB50 
        // feb50

        String orgCouponCode = "FeB50";
        String userCouponCode = "FeB50";

        System.out.println( orgCouponCode == "FeB50" );


    }
}
