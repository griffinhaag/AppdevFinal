package creatures;

// Dragon subclass representing a creature with fire power
public class Dragon extends Creature implements Ability {
    private int firePower; // Unique attribute for Dragon

    // Constructor to initialize a Dragon
    public Dragon(String name, int age, int firePower) {
        super(name, age, "Dragon");
        this.firePower = firePower;
    }

    // Getter and setter for fire power
    public int getFirePower() {
        return firePower;
    }

    public void setFirePower(int firePower) {
        this.firePower = firePower;
    }

    // Method to display Dragon's details
    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Type: " + getType() +
                ", Age: " + getAge() + ", Fire Power: " + firePower);
    }

    // Ability implementation for breathing fire
    @Override
    public void executeAbility() {
        System.out.println(getName() + " breathes fire with power " + firePower + "!");
    }
}
