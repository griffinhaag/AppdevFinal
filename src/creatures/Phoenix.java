package creatures;

// Phoenix subclass representing a creature with resurrection abilities
public class Phoenix extends Creature implements Ability {
    private int rebirthCount; // Unique attribute for Phoenix

    // Constructor to initialize a Phoenix
    public Phoenix(String name, int age, int rebirthCount) {
        super(name, age, "Phoenix");
        this.rebirthCount = rebirthCount;
    }

    // Getter and setter for rebirth count
    public int getRebirthCount() {
        return rebirthCount;
    }

    public void setRebirthCount(int rebirthCount) {
        this.rebirthCount = rebirthCount;
    }

    // Method to display Phoenix's details
    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Type: " + getType() +
                ", Age: " + getAge() + ", Rebirth Count: " + rebirthCount);
    }

    // Ability implementation for resurrection
    @Override
    public void executeAbility() {
        System.out.println(getName() + " resurrects with rebirth count " + rebirthCount + "!");
    }
}
