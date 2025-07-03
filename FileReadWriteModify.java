import java.io.*;
import java.util.Scanner;

public class FileReadWriteModify {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        Scanner sc = new Scanner(System.in);

        try {
            // Writing to the file
            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is the initial content.\n");
            writer.close();
            System.out.println("File written successfully.");

            // Reading the file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // Modifying (appending) the file
            FileWriter appendWriter = new FileWriter(fileName, true);
            appendWriter.write("This line is added as modification.\n");
            appendWriter.close();
            System.out.println("File modified successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        sc.close();
    }
}
