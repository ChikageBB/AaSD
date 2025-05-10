package first_lesson;

import java.io.IOException;

public class TestInputSystemIn {
    public static void main(String[] args) {
        System.out.print("Enter a character: ");
        try {
            int inputInt = System.in.read();  // Read a single byte (ASCII value)
            char inputChar = (char) inputInt; // Convert ASCII value to char
            System.out.println("You entered: " + inputChar);
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}
