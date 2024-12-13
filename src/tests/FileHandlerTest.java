package tests;

import creatures.*;
import utils.FileHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for FileHandler class
public class FileHandlerTest {
    private FileHandler fileHandler;
    private List<Creature> creatures;

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandler();
        creatures = new ArrayList<>();
        creatures.add(new Dragon("FireWing", 5, 80));
        creatures.add(new Unicorn("SilverHorn", 7, "Silver"));
        creatures.add(new Phoenix("FlameTail", 3, 2));
    }

    @Test
    void testSaveAndLoad() {
        String filename = "test_creatures.dat";
        
        // Save creatures to file
        fileHandler.saveToFile(filename, creatures);
        File file = new File(filename);
        assertTrue(file.exists());

        // Load creatures from file
        List<Creature> loadedCreatures = fileHandler.loadFromFile(filename);
        assertNotNull(loadedCreatures);
        assertEquals(3, loadedCreatures.size());

        // Verify loaded creatures match the original
        assertEquals("FireWing", loadedCreatures.get(0).getName());
        assertEquals("SilverHorn", loadedCreatures.get(1).getName());
        assertEquals("FlameTail", loadedCreatures.get(2).getName());

        // Clean up test file
        assertTrue(file.delete());
    }

    @Test
    void testLoadNonexistentFile() {
        List<Creature> loadedCreatures = fileHandler.loadFromFile("nonexistent.dat");
        assertNull(loadedCreatures);
    }
}
