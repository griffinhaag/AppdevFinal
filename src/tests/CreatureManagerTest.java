package tests;

import creatures.*;
import managers.CreatureManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for CreatureManager class
public class CreatureManagerTest {
    private CreatureManager manager;

    @BeforeEach
    void setUp() {
        manager = new CreatureManager();
        manager.addCreature(new Dragon("FireWing", 5, 80));
        manager.addCreature(new Unicorn("SilverHorn", 7, "Silver"));
        manager.addCreature(new Phoenix("FlameTail", 3, 2));
    }

    @Test
    void testAddCreature() {
        manager.addCreature(new Dragon("SkyBlaze", 10, 90));
        assertEquals(4, manager.getCreatures().size());
    }

    @Test
    void testRemoveCreature() {
        manager.removeCreature("SilverHorn");
        assertEquals(2, manager.getCreatures().size());
        assertTrue(manager.getCreatures().stream().noneMatch(c -> c.getName().equals("SilverHorn")));
    }

    @Test
    void testFilterByType() {
        List<Creature> dragons = manager.getCreatures().stream()
                .filter(c -> c.getType().equalsIgnoreCase("Dragon"))
                .toList();
        assertEquals(1, dragons.size());
        assertEquals("FireWing", dragons.get(0).getName());
    }

    @Test
    void testShowStatistics() {
        double averageAge = manager.getCreatures().stream().mapToInt(Creature::getAge).average().orElse(0);
        assertEquals(5.0, averageAge); // (5 + 7 + 3) / 3 = 5.0
    }
}
