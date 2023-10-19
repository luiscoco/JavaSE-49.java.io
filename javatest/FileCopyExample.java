import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        // Use absolute paths
        String sourcePath = "/home/runner/work/JavaSE-49.java.io/javatest/input.txt";
        String destinationPath = "/home/runner/work/JavaSE-49.java.io/javatest/output.txt";

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
