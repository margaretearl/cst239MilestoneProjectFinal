package cst239MilestoneProject;

// Margo Earl
// CST239
// Milestone 7
// 12/3/23-12/10/23
// This is my own work

// Attributes: Name, Description, Price, Quantity.
// Methods: Getters and setters for the above.

// SalableProduct class represents a product that can be sold in the store.
public class SalableProduct implements Comparable<SalableProduct> {
    private String name;
    private String description;
    private double price;
    private int quantity;

    // Constructors
    // Creates a new SalableProduct with the specified attributes.
    public SalableProduct(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    // Get the name of the product.
    public String getName() {
        return name;
    }

    // Set the name of the product.
    public void setName(String name) {
        this.name = name;
    }

    // Get the price of the product.
    public double getPrice() {
        return price;
    }

    // Set the price of the product.
    public void setPrice(double price) {
        this.price = price;
    }

    // Get the description of the product.
    public String getDescription() {
        return description;
    }

    // Get the quantity of the product.
    public int getQuantity() {
        return quantity;
    }

    // Set the quantity of the product.
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // compareTo method is overridden from Comparable interface.
    // It compares two SalableProduct objects based on their names.
    @Override
    public int compareTo(SalableProduct otherProduct) {
        // Compare based on product name, ignoring case.
        return this.getName().compareToIgnoreCase(otherProduct.getName());
    }
}
