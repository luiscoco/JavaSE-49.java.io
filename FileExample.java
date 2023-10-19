import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        
        //This path is used because the github action agent is running in Linux
        File file = new File("C:/javatest/example.txt");
        
        //This is the path for running in window operating system
        // File file = new File("C:\\javatest\\example.txt");

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists!");
        } else {
            System.out.println("File does not exist.");
        }
    }
}
