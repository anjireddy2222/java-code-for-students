 class AndOrNot {

    public static void main(String[] args) {
        
        // OR operator
        final int adminId = 10;
        final int editorId = 15;
        final int viewId = 22;

        int loggedInUserId = 10;
        

        // if( adminId == loggedInUserId ){ // false
        //     System.out.println("Welcome Admin");
        // }else if( editorId == loggedInUserId ){ // false
        //     System.out.println("Welcome Editor");
        // }else if( viewId == loggedInUserId){
        //     System.out.println("You can't edit");
        // }else{
        //     System.out.println("You don't have access ");
        // }

        switch( loggedInUserId ){
            case 10:
                System.out.println("Welcome Admin");
                break;
            case editorId:
                System.out.println("Welcome Editor");
                break;
            case viewId:
                System.out.println("View access only.");
                break;
            default:
                System.out.println("You don't have access");


        }





        

        

        








    }
    
}
