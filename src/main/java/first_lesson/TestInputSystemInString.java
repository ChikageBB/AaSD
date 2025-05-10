package first_lesson;

import java.io.IOException;

public class TestInputSystemInString {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        try {
            StringBuilder userInput = new StringBuilder();
            int inputInt;

            // Read the chars in a loop, until new line ('\n') symbol occurred
            while ((inputInt = System.in.read()) != -1 && inputInt != '\n') {
                char inputChar = (char) inputInt;
                userInput.append(inputChar);
            }

            String inputString = userInput.toString();
            System.out.println("You entered: " + inputString);
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}
