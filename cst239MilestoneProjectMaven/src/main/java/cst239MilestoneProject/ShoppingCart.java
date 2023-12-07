package cst239MilestoneProject;

// Margo Earl
// CST239
// Milestone 7
// 12/3/23-12/10/23
// This is my own work

import java.util.ArrayList;
import java.util.List;

// ShoppingCart class represents the user's shopping cart in the store.
public class ShoppingCart {
    private List<SalableProduct> items;

    // Constructor initializes an empty shopping cart.
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Adds a specified quantity of a product to the cart.
    public void addToCart(SalableProduct product, int quantity) {
        int index = items.indexOf(product);

        // If the product is already in the cart, update its quantity.
        if (index != -1) {
            SalableProduct existingProduct = items.get(index);
            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
        } else {
            // If the product is not in the cart, add a new product with the specified quantity.
            SalableProduct newProduct = new SalableProduct(
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    quantity
            );
            items.add(newProduct);
        }
        System.out.println(quantity + " " + product.getName() + "(s) added to the cart!");
    }

    // Removes a specified product from the cart.
    public void removeFromCart(SalableProduct product) {
        items.remove(product);
        System.out.println("Product removed from cart: " + product.getName());
    }

    // Displays the items currently in the cart.
    public void viewCart() {
        System.out.println("Items in the cart:");
        for (SalableProduct product : items) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    // Returns a copy of the list of items in the cart.
    public List<SalableProduct> getItems() {
        return new ArrayList<>(items);
    }

    // Empties the shopping cart, removing all items.
    public void emptyCart() {
        items.clear();
        System.out.println("Shopping cart emptied.");
    }
}