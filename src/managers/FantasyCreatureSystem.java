package managers;

import creatures.*;
import utils.FileHandler;

import java.util.List; // Import for List interface
import java.util.Scanner;

// Main class to run the Fantasy Creature Management System
public class FantasyCreatureSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreatureManager manager = new CreatureManager();
        FileHandler fileHandler = new FileHandler();
        String filename = "creatures.dat";

        while (true) {
            // Display the menu
            System.out.println("\n--- Creature Management ---");
            System.out.println("1. Add Creature");
            System.out.println("2. Remove Creature");
            System.out.println("3. Display Creatures");
            System.out.println("4. Filter by Type");
            System.out.println("5. Show Statistics");
            System.out.println("6. Save Data");
            System.out.println("7. Load Data");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // Add a new creature
                    System.out.print("Enter type (Dragon/Unicorn/Phoenix): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (type.toLowerCase()) {
                        case "dragon" -> {
                            System.out.print("Enter fire power: ");
                            int firePower = scanner.nextInt();
                            manager.addCreature(new Dragon(name, age, firePower));
                        }
                        case "unicorn" -> {
                            System.out.print("Enter horn color: ");
                            String hornColor = scanner.nextLine();
                            manager.addCreature(new Unicorn(name, age, hornColor));
                        }
                        case "phoenix" -> {
                            System.out.print("Enter rebirth count: ");
                            int rebirthCount = scanner.nextInt();
                            manager.addCreature(new Phoenix(name, age, rebirthCount));
                        }
                        default -> System.out.println("Invalid type.");
                    }
                }
                case 2 -> {
                    // Remove a creature
                    System.out.print("Enter name of the creature to remove: ");
                    String name = scanner.nextLine();
                    manager.removeCreature(name);
                }
                case 3 -> manager.displayCreatures(); // Display all creatures
                case 4 -> {
                    // Filter creatures by type
                    while (true) {
                        System.out.print("Enter type to filter by (Dragon/Unicorn/Phoenix): ");
                        String type = scanner.nextLine();
                        List<Creature> filtered = manager.getCreatures().stream()
                                .filter(c -> c.getType().equalsIgnoreCase(type))
                                .toList();
                        if (filtered.isEmpty()) {
                            System.out.println("Type '" + type + "' was not found. Please try again.");
                        } else {
                            filtered.forEach(Creature::displayInfo);
                            break;
                        }
                    }
                }
                case 5 -> manager.showStatistics(); // Show statistics
                case 6 -> fileHandler.saveToFile(filename, manager.getCreatures()); // Save data
                case 7 -> {
                    // Load data
                    List<Creature> loadedCreatures = fileHandler.loadFromFile(filename);
                    if (loadedCreatures != null) {
                        manager.getCreatures().clear();
                        manager.getCreatures().addAll(loadedCreatures);
                        System.out.println("Data loaded successfully.");
                    } else {
                        System.out.println("No data found or failed to load.");
                    }
                }
                case 8 -> {
                    // Exit program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
