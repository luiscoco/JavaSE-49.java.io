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
        File file = new File("C:\\javatest\\example.txt");

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
        try (FileInputStream fis = new FileInputStream("C:\\javatest\\input.txt");
             FileOutputStream fos = new FileOutputStream("C:\\javatest\\output.txt")) {

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
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\javatest\\input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\javatest\\output.txt"))) {

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

# More samples 

Let's explore a few more examples using different classes from the java.io package:

## DataInputStream and DataOutputStream

Used for reading and writing primitive data types.

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOExample {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\javatest\\data.dat"));
             DataInputStream dis = new DataInputStream(new FileInputStream("C:\\javatest\\data.dat"))) {

            // Writing data
            dos.writeInt(42);
            dos.writeDouble(3.14);
            dos.writeUTF("Hello, Java!");

            // Reading data
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            String stringValue = dis.readUTF();

            System.out.println("Int Value: " + intValue);
            System.out.println("Double Value: " + doubleValue);
            System.out.println("String Value: " + stringValue);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## ObjectInputStream and ObjectOutputStream

Used for reading and writing objects.

```java
import java.io.*;

class Person implements Serializable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ObjectIOExample {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\javatest\\person.dat"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\javatest\\person.dat"))) {

            // Writing object
            Person person = new Person("John Doe", 25);
            oos.writeObject(person);

            // Reading object
            Person restoredPerson = (Person) ois.readObject();
            System.out.println("Name: " + restoredPerson.name);
            System.out.println("Age: " + restoredPerson.age);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

These examples cover different aspects of input and output in Java, including primitive data types, strings, and object serialization.

# More advanced topics related to java.io

## NIO (New I/O)

The java.nio package provides a more scalable and flexible alternative to the traditional I/O classes. It introduces concepts like channels and buffers.

```java
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

public class NIOExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\javatest\\nio_example.txt");

        // Writing data using Files and Paths
        try {
            Files.write(path, "Hello, NIO!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading data using Files and Paths
        try {
            String content = new String(Files.readAllBytes(path));
            System.out.println("File Content: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## ZipInputStream and ZipOutputStream

Used for reading and writing data in ZIP format.

```java
import java.io.*;
import java.util.zip.*;

public class ZipExample {
    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("archive.zip"))) {
            // Add a file to the ZIP archive
            zos.putNextEntry(new ZipEntry("file.txt"));

            // Write data to the ZIP file
            byte[] data = "Hello, ZIP!".getBytes();
            zos.write(data, 0, data.length);

            // Close the entry
            zos.closeEntry();

            System.out.println("ZIP file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## RandomAccessFile:

Provides a way to read and write data at random positions in a file.

```java
import java.io.*;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("random_file.txt", "rw")) {
            // Write data at a specific position
            raf.seek(10);
            raf.writeBytes("RandomAccess");

            // Read data from a specific position
            raf.seek(5);
            byte[] buffer = new byte[10];
            raf.read(buffer);

            System.out.println("Data read: " + new String(buffer));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
```

These examples touch on more advanced aspects of file handling in Java, such as the NIO package for improved I/O operations, working with ZIP files, and random access to files. 


