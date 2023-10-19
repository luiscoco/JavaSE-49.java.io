# JavaSE-java.io

The java.io package provides a set of classes for input and output operations in Java. It includes classes for reading and writing data to files, streams, and other I/O sources.

Here are some key classes and their basic functionalities:

## File class

Represents a file or directory pathname.

Allows you to create, delete, and query information about files and directories.

```java
import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("example.txt");

        // Check if the file exists
        if (file.exists()) {
            System.out.println("File exists!");
        } else {
            System.out.println("File does not exist.");
        }
    }
}
```

## FileInputStream and FileOutputStream

Used for reading and writing binary data from and to files.

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## BufferedReader and BufferedWriter

Used for reading and writing text data more efficiently by buffering the data.

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileCopyExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();  // Add a newline character
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

These are just a few examples to get you started with java.io. There are many other classes and functionalities in this package, but these should give you a good foundation.

