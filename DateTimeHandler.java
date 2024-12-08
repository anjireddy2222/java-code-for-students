import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHandler {

public static void main(String[] args) {

    



    
String dateTimeString = "2024-03-22T21:35:35";
LocalDateTime generatedAt = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
LocalDateTime submittedAt = LocalDateTime.now();


Duration.between(generatedAt, submittedAt).toMinutes()









}
    
}
