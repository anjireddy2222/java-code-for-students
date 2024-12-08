
public class VideoActions extends Payments implements VideoActionsInterface, CommentsInterface {

    public static void main(String[] args){

        VideoActions objVideoActions = new VideoActions();
        objVideoActions.Like();

        

        
    }

    public void Like(){

        System.out.println("Video liked Comedy" + Videocategory.MOVIES);
    }

    public void Dislike(){
        System.out.println("Video Unliked");
    }

    public void Save(){
        System.out.println("Video saved to your watch list");
    }

    public void Clip(){
        System.out.println("You can't clip this video COMEDY");
    }

    public void Report(){
        System.out.print("We are reviewing your feedback Comedy");
    }

    public void Download(){
        System.out.println("Download in progress");
    }

    public void AddComment(){
        System.out.println("Add Comment");
    }

    public void UpdateComment(){
        System.out.println("COmment updated");
    }

    public void DeleteComment(){
        System.out.println("Comment deleted");
    }

    public void ViewComments(){
        System.out.println("Comments list");
    }

    





}






