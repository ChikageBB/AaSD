package first_lesson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestFileRead {
    public static void main(String[] args) {
        // Read lines from a file into a list
        List<String> lines = readLinesFromFile("writer_output.txt");

        // Write lines from the list to another file
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();

        // Init a Buffered reader from java.io.*
        try (BufferedReader reader = new BufferedReader(
                new FileReader(filePath))) {
            // Read all lines until the line is not null
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return lines;
    }
}
