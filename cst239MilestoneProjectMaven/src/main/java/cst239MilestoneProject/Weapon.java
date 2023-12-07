package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

// Weapon class represents a type of salable product with additional attributes specific to weapons.
// It extends the SalableProduct class and implements Comparable for sorting purposes.
public class Weapon extends SalableProduct implements Comparable<SalableProduct> {

    // Constructor for creating a new Weapon instance.
    public Weapon(String name, String description, double price, int quantity, int damage) {
        // Call the constructor of the parent class (SalableProduct) with provided parameters.
        super(name, description, price, quantity);
    }

    // Override the compareTo method to compare Weapons based on their names.
    @Override
    public int compareTo(SalableProduct otherWeapon) {
        // Ignore case when comparing names, as compareToIgnoreCase is used for string comparison.
        return this.getName().compareToIgnoreCase(otherWeapon.getName());
    }
}