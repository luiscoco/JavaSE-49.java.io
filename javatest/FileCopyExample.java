import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        // Print the current directory
        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        // List the contents of the javatest directory
        File javatestDirectory = new File("/home/runner/work/JavaSE-49.java.io/JavaSE-49.java.io/javatest");
        String[] contents = javatestDirectory.list();
        System.out.println("Contents of javatest directory:");
        if (contents != null) {
            for (String file : contents) {
                System.out.println(file);
            }
        }

        // Use absolute paths
        String sourcePath = "/home/runner/work/JavaSE-49.java.io/JavaSE-49.java.io/javatest/input.txt";
        String destinationPath = "/home/runner/work/JavaSE-49.java.io/JavaSE-49.java.io/javatest/output.txt";

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
