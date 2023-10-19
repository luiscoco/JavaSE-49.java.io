import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

public class FileCopyExample {
    public static void main(String[] args) {
        // Print the current directory
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        // Use absolute paths
        Path sourcePath = Paths.get(System.getProperty("user.dir"), "javatest", "input.txt");
        Path destinationPath = Paths.get(System.getProperty("user.dir"), "javatest", "output.txt");

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
