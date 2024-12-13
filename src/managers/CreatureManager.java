package managers;

import creatures.Creature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Class to manage a collection of creatures
public class CreatureManager {
    private List<Creature> creatures; // List to store creatures

    // Constructor to initialize the creature list
    public CreatureManager() {
        creatures = new ArrayList<>();
    }

    // Method to add a creature to the list
    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    // Method to remove a creature by name
    public void removeCreature(String name) {
        creatures.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    // Method to display all creatures in the list
    public void displayCreatures() {
        if (creatures.isEmpty()) {
            System.out.println("No creatures available.");
        } else {
            creatures.forEach(Creature::displayInfo);
        }
    }

    // Method to filter creatures by their type
    public void filterByType(String type) {
        creatures.stream()
                .filter(c -> c.getType().equalsIgnoreCase(type))
                .forEach(Creature::displayInfo);
    }

    // Method to show statistics about the creatures
    public void showStatistics() {
        if (creatures.isEmpty()) {
            System.out.println("No creatures available to show statistics.");
            return;
        }
        double averageAge = creatures.stream()
                                     .mapToInt(Creature::getAge)
                                     .average()
                                     .orElse(0);
        System.out.println("Average Age: " + averageAge);

        System.out.println("Type Distribution:");
        creatures.stream()
                 .map(Creature::getType)
                 .distinct()
                 .forEach(type -> System.out.println(type + ": " +
                         creatures.stream().filter(c -> c.getType().equals(type)).count()));
    }

    // Getter for the creatures list
    public List<Creature> getCreatures() {
        return creatures;
    }
}
