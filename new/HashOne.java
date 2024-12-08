import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashOne {

    public static void main(String[] args) {
        

        
        String filePath = "uploadczs/file.txt";

        
        try {
            FileWriter writer = new FileWriter(filePath);
            
            writer.write("This is a sample text file.");
            writer.write("\n");
            writer.write("You can write any text here.");
            System.out.println("Text file created successfully.");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        
    







    }
    
}
