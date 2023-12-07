package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StoreFront {
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;

    public StoreFront() {
        this.inventoryManager = new InventoryManager();
        this.shoppingCart = new ShoppingCart();
    }

    public List<SalableProduct> getInventory() {
        return inventoryManager.getProducts();
    }

    public void viewCart() {
        List<SalableProduct> cartItems = shoppingCart.getItems();
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (SalableProduct product : cartItems) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        }
    }

    public void initializeStore() {
        // Initializes store and inventory
        System.out.println("Welcome Traveler to Ye Old Fantasy SamsClub, please, look around for a while!.");

        // Load initial inventory from JSON file
        List<SalableProduct> initialInventory = loadInitialInventoryFromJson("initialInventory.json");

        // Set initial inventory in the InventoryManager
        inventoryManager.initializeStoreInventory(initialInventory);

        // Initialize the shopping cart
        shoppingCart = new ShoppingCart();
    }

    // Load initial inventory from JSON file
    private List<SalableProduct> loadInitialInventoryFromJson(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
 
            Gson gson = new Gson();
            Type productListType = new TypeToken<List<SalableProduct>>() {}.getType();
            return gson.fromJson(reader, productListType);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading initial inventory from JSON file: " + e.getMessage());
        }
        return Collections.emptyList(); // or handle the error as appropriate
    }


    // Returns a product from the inventory based on its name.
    public SalableProduct getProductByName(String name) {
        return inventoryManager.getProductByName(name);
    }

    // Adds a list of new products to the inventory.
    public void addProductsToInventory(List<SalableProduct> newProducts) {
        inventoryManager.addProductsToInventory(newProducts);
    }

    // Removes a product from the inventory.
    public void removeProductFromInventory(SalableProduct product) {
        inventoryManager.removeProductFromInventory(product);
    }

    // Returns the entire inventory.
    public List<SalableProduct> getEntireInventory() {
        return inventoryManager.getEntireInventory();
    }
    public void purchaseProduct(SalableProduct product) {
        // Processes purchase of the SalableProduct
        if (inventoryManager.getProducts().contains(product)) {
            if (product instanceof Weapon) {
                Weapon weapon = (Weapon) product;
                // Logic for purchasing weapon
                System.out.println("Weapon purchased: " + weapon.getName());
            } else if (product instanceof Armor) {
                Armor armor = (Armor) product;
                // Logic for purchasing armor
                System.out.println("Armor purchased: " + armor.getName());
            } else if (product instanceof Health) {
                Health health = (Health) product;
                // Logic for purchasing health item
                System.out.println("Health item purchased: " + health.getName());
            }
        } else {
            System.out.println("Product not found in inventory: " + product.getName());
        }
    }

    public void cancelPurchase(SalableProduct product) {
        // Cancels purchase of the SalableProduct
        if (shoppingCart.getItems().contains(product)) {
            if (product instanceof Weapon) {
                // Logic for cancelling weapon purchase
                System.out.println("Weapon purchase cancelled: " + product.getName());
            } else if (product instanceof Armor) {
                // Logic for cancelling armor purchase
                System.out.println("Armor purchase cancelled: " + product.getName());
            } else if (product instanceof Health) {
                // Logic for cancelling health item purchase
                System.out.println("Health item purchase cancelled: " + product.getName());
            }
        } else {
            System.out.println("Product not found in cart: " + product.getName());
        }
    }
 // Adds a specified quantity of a product to the shopping cart.
    public void addToCart(SalableProduct product, int quantity) {
        if (inventoryManager.getProducts().contains(product)) {
            int availableQuantity = product.getQuantity();
            if (availableQuantity >= quantity) {
                product.setQuantity(availableQuantity - quantity);
                shoppingCart.addToCart(product, quantity);

                System.out.println(quantity + " " + product.getName() + "(s) added to the cart!");
            } else {
                System.out.println("Not enough quantity in stock for " + product.getName());
            }
        } else {
            System.out.println("Product not found in inventory: " + product.getName());
        }
    }

 // Removes a product from the shopping cart.
    public void removeFromCart(SalableProduct product) {
        shoppingCart.removeFromCart(product);
    }

    // Returns the list of items in the shopping cart.
    public List<SalableProduct> getShoppingCart() {
        return shoppingCart.getItems();
    }

    // Empties the shopping cart.
    public void emptyShoppingCart() {
        shoppingCart.emptyCart();
    }

    // Displays the entire inventory sorted by name.
    public void viewInventorySortedByName(boolean ascending) {
        List<SalableProduct> inventory = inventoryManager.getEntireInventory();
        inventory.sort(Comparator.naturalOrder()); // Sort by name in ascending order

        if (!ascending) {
            Collections.reverse(inventory); // Reverse for descending order
        }

        System.out.println("Inventory (Sorted by Name):");
        for (SalableProduct product : inventory) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    // Displays the entire inventory sorted by price.
    public void viewInventorySortedByPrice(boolean ascending) {
        List<SalableProduct> inventory = inventoryManager.getEntireInventory();
        inventory.sort(Comparator.comparingDouble(SalableProduct::getPrice)); // Sort by price

        if (!ascending) {
            Collections.reverse(inventory); // Reverse for descending order
        }

        System.out.println("Inventory (Sorted by Price):");
        for (SalableProduct product : inventory) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    // Adds new products to the inventory.
    public void updateInventory(List<SalableProduct> newProducts) {
        inventoryManager.addProductsToInventory(newProducts);
        System.out.println("Store Front inventory updated.");
    }

    // Returns the inventory as a JSON string.
    public String returnInventory() {
        List<SalableProduct> inventory = inventoryManager.getEntireInventory();
        Gson gson = new Gson();
        return gson.toJson(inventory);
    }

    // Processes a network command using the CommandProcessor.
    public void processNetworkCommand(String command) {
        CommandProcessor commandProcessor = new CommandProcessor(this);
        commandProcessor.processCommand(command);
    }
}