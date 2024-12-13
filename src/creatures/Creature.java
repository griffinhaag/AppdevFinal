package creatures;

import java.io.Serializable;

// Abstract class representing a general creature with common attributes and methods
public abstract class Creature implements Serializable {
    private String name;
    private int age;
    private String type;

    // Constructor to initialize common creature properties
    public Creature(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    // Getters and setters for common attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    // Abstract method to be implemented by specific creatures to display their unique details
    public abstract void displayInfo();
}
