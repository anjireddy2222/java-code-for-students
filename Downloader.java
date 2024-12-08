public class Downloader implements Runnable{
    
    String file = "";

    public Downloader(String path){
        file = path;
    }

    public void run(){
        System.out.println("Downloading " + file);
    }
    
}
