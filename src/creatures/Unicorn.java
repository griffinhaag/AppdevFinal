package creatures;

// Unicorn subclass representing a creature with a magical horn
public class Unicorn extends Creature implements Ability {
    private String hornColor; // Unique attribute for Unicorn

    // Constructor to initialize a Unicorn
    public Unicorn(String name, int age, String hornColor) {
        super(name, age, "Unicorn");
        this.hornColor = hornColor;
    }

    // Getter and setter for horn color
    public String getHornColor() {
        return hornColor;
    }

    public void setHornColor(String hornColor) {
        this.hornColor = hornColor;
    }

    // Method to display Unicorn's details
    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Type: " + getType() +
                ", Age: " + getAge() + ", Horn Color: " + hornColor);
    }

    // Ability implementation for healing with the magical horn
    @Override
    public void executeAbility() {
        System.out.println(getName() + " uses its magical horn to heal!");
    }
}
