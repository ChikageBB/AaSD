package first_lesson;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        // Creating a list and adding coffee types
        List<String> coffeeList = new ArrayList<>();
        coffeeList.add("Espresso");
        coffeeList.add("Cappuccino");
        coffeeList.add("Latte");
        coffeeList.add("Americano");

        // Displaying the list
        System.out.println("Original Coffee List: " + coffeeList);

        // Accessing the element by its index
        System.out.println("A sort of coffee at index [1]: " + coffeeList.get(1));

        // Adding coffee types at specific positions
        coffeeList.add(2, "Mocha"); // Adds "Mocha" at index 2

        // Displaying the list after adding at a specific position
        System.out.println("Coffee List after inserting 'Mocha' at index 2: " + coffeeList);

        // Removing a coffee type
        coffeeList.remove("Cappuccino");

        // Displaying the list after removing a coffee type
        System.out.println("Coffee List after removing 'Cappuccino': " + coffeeList);

        // Removing coffee type at a specific position
        String removedCoffee = coffeeList.remove(1); // Removes coffee type at index 1

        // Displaying the list and the removed coffee type
        System.out.println("Coffee List after removing at index 1: " + coffeeList);
        System.out.println("Removed Coffee Type: " + removedCoffee);

        // Checking if a specific coffee type is present
        boolean containsLatte = coffeeList.contains("Latte");

        // Displaying the result of the contains check
        System.out.println("Does the coffee list contain 'Latte'? " + containsLatte);

        // Getting the index of a coffee type
        int indexOfAmericano = coffeeList.indexOf("Americano");

        // Displaying the index of "Americano"
        System.out.println("Index of 'Americano': " + indexOfAmericano);
    }
}
