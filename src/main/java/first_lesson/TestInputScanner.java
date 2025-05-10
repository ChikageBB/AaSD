package first_lesson;

import java.util.Scanner;

public class TestInputScanner {
    public static void main(String[] args) {
        // Bind a scanner to System.in stream
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String userInput = scanner.nextLine();

        System.out.println("You entered: " + userInput);

        // Close the scanner
        scanner.close();
    }
}
