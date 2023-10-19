import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {
    public static void main(String[] args) {

        // Print the current directory
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        try (             
             //These are the paths for Linux operating system
             FileInputStream fis = new FileInputStream("javatest/input.txt");
             FileOutputStream fos = new FileOutputStream("javatest/output.txt")) 

             //These are the paths for Windows operating system
             //FileInputStream fis = new FileInputStream("C:\\javatest\\input.txt");
             //FileOutputStream fos = new FileOutputStream("C:\\javatest\\output.txt")) 
        {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully.");

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
