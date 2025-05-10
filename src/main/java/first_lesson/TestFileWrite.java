package first_lesson;

import java.io.*;
import java.util.List;
import java.util.Arrays;

public class TestFileWrite {
    public static void main(String[] args) {
        // Expandable ordered data structure - List
        List<String> linesToWrite = Arrays.asList("The", "Coffee", "of", "the", "Internet");

        // Write lines from the list to another file
        writeLinesToFile("writer_output.txt", linesToWrite);
    }

    private static void writeLinesToFile(String filePath, List<String> lines) {
        // Init a Buffered Writer from the java.io package
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filePath))) {
            // Modern-style loop
            for (String line : lines) {
                writer.write(line);
                writer.newLine();  // Add a newline character
            }


            System.out.println("Lines written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
