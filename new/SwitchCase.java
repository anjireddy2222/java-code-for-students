public class SwitchCase {

    public static void main(String[] args) {
        
        String videoCategory = "devotional";

        switch(videoCategory){

            case "sports":
                System.out.println("Display sportts related videos");
                break;

            case "music":
                System.out.println("Display music realted videos");
                break;
            
            case "coding":
                System.out.println("Display coding related video");
                break;

        }

        String[] names = {"Anji", "Reddy", "Akkala"};
        System.out.println(names[0]);


    }
    
}
