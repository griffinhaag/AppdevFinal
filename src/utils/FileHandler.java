package utils;

import creatures.Creature;

import java.io.*;
import java.util.List;

// Class to handle saving and loading creature data
public class FileHandler {

    // Method to save a list of creatures to a file
    public void saveToFile(String filename, List<Creature> creatures) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(creatures);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Method to load a list of creatures from a file
    @SuppressWarnings("unchecked")
    public List<Creature> loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Creature>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return null;
        }
    }
}
