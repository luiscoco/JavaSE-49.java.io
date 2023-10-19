import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyExample {
    public static void main(String[] args) {
        // Print the current directory
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        Path sourcePath = Paths.get("javatest/input.txt");
        Path destinationPath = Paths.get("javatest/output.txt");

        try {
            Files.copy(sourcePath, destinationPath);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
