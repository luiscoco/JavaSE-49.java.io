import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        // Print the current directory
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        // Use absolute paths
        String sourcePath = System.getProperty("user.dir") + "/javatest/input.txt";
        String destinationPath = System.getProperty("user.dir") + "/javatest/output.txt";

        try (InputStream inputStream = new FileInputStream(sourcePath);
             OutputStream outputStream = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
