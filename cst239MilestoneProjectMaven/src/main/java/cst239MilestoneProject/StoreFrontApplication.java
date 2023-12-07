package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import java.util.List;
import java.util.Scanner;

//StoreFrontApplication class is the main application that interacts with the user.
public class StoreFrontApplication {
 public static void main(String[] args) {
     // Create an instance of StoreFront and initialize the store
     StoreFront storeFront = new StoreFront();
     storeFront.initializeStore();

     // Create a Scanner object to take user input
     Scanner scanner = new Scanner(System.in);
     int choice;

     // Start a loop for the main menu
     do {
         System.out.println("Welcome to Ye Old Fantasy SamsClub!");
         System.out.println("1. View Inventory");
         System.out.println("2. Sort Inventory");
         System.out.println("3. Remove Product from Cart");
         System.out.println("4. View Cart");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         // Use a switch statement to handle different user choices
         switch (choice) {
             case 1:
                 // View Inventory
                 System.out.println("Inventory:");

                 // Display the inventory and item details
                 List<SalableProduct> inventory = storeFront.getInventory();
                 for (int i = 0; i < inventory.size(); i++) {
                     SalableProduct product = inventory.get(i);
                     System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
                 }

                 System.out.print("Enter the number of the item to view details: ");
                 int itemNumber = scanner.nextInt();
                 if (itemNumber >= 1 && itemNumber <= inventory.size()) {
                     SalableProduct selectedProduct = inventory.get(itemNumber - 1);
                     System.out.println("Item details:");
                     System.out.println("Name: " + selectedProduct.getName());
                     System.out.println("Description: " + selectedProduct.getDescription());
                     System.out.println("Price: $" + selectedProduct.getPrice());
                     System.out.println("Quantity in stock: " + selectedProduct.getQuantity());

                     // Ask the user if they want to add the item to the cart
                     System.out.print("Do you want to add this item to the cart? (1 for Yes, 2 for No): ");
                     int addToCartChoice = scanner.nextInt();
                     if (addToCartChoice == 1) {
                         storeFront.addToCart(selectedProduct, addToCartChoice);
                         System.out.println("Item added to the cart!");
                     } else {
                         System.out.println("Item not added to the cart.");
                     }

                     // Ask the user if they want to sort the inventory
                     System.out.print("Do you want to sort the inventory? (1 for Sort by Name, 2 for Sort by Price, 3 for No): ");
                     int sortChoice = scanner.nextInt();
                     switch (sortChoice) {
                         case 1:
                             storeFront.viewInventorySortedByName(true);
                             break;
                         case 2:
                             storeFront.viewInventorySortedByPrice(true);
                             break;
                         default:
                             // Do nothing, continue without sorting
                     }
                 } else {
                     System.out.println("Invalid item number.");
                 }
                 break;
             case 2:
                 // Sort Inventory
                 System.out.print("Do you want to sort the inventory? (1 for Sort by Name, 2 for Sort by Price, 3 for No): ");
                 int sortChoice = scanner.nextInt();
                 switch (sortChoice) {
                     case 1:
                         storeFront.viewInventorySortedByName(true);
                         break;
                     case 2:
                         storeFront.viewInventorySortedByPrice(true);
                         break;
                     default:
                         // Do nothing, continue without sorting
                 }
                 break;
             case 3:
                 // Remove Product from Cart
                 System.out.println("Your cart:");
                 List<SalableProduct> cartItems = storeFront.getShoppingCart();
                 if (cartItems.isEmpty()) {
                     System.out.println("Your cart is empty.");
                 } else {
                     for (int i = 0; i < cartItems.size(); i++) {
                         SalableProduct product = cartItems.get(i);
                         System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
                     }

                     System.out.print("Enter the number of the item to remove from the cart: ");
                     int removeFromCartNumber = scanner.nextInt();

                     if (removeFromCartNumber >= 1 && removeFromCartNumber <= cartItems.size()) {
                         SalableProduct removedProduct = cartItems.get(removeFromCartNumber - 1);
                         storeFront.removeFromCart(removedProduct);
                         System.out.println("Item removed from the cart: " + removedProduct.getName());
                     } else {
                         System.out.println("Invalid item number.");
                     }
                 }
                 break;
             case 4:
                 // View Cart
                 storeFront.viewCart();
                 break;
             case 5:
                 // Exit
                 System.out.println("Thank you for shopping at Ye Old Fantasy SamsClub!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     } while (choice != 5);

     // Close the Scanner
     scanner.close();
 }
}