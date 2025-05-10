package first_lesson;

import java.util.Scanner;

public class TestInputScannerMultiline {
    public static void main(String[] args) {
        // Bind a scanner to System.in stream
        Scanner scanner = new Scanner(System.in);

        // Read the lines in an infinite loop
        while (true) {
            System.out.print("Enter a text (or 'exit'): ");
            String userInput = scanner.nextLine();

            // Process the 'exit' command
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.println("You entered: " + userInput);
        }

        // Close the scanner
        scanner.close();
    }
}
