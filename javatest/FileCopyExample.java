import java.io.IOException;
import java.nio.file.*;

public class FileCopyExample {
    public static void main(String[] args) {
        // Print the current directory
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        // Use absolute paths
        Path sourcePath = Paths.get("/home/runner/work/JavaSE-49.java.io/JavaSE-49.java.io/javatest/input.txt");
        Path destinationPath = Paths.get("/home/runner/work/JavaSE-49.java.io/JavaSE-49.java.io/javatest/output.txt");

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
