package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import java.util.ArrayList;
import java.util.List;

//InventoryManager class manages the inventory of SalableProducts in the store.
public class InventoryManager {
 private List<SalableProduct> products;

 // Set the list of products in the inventory.
 public void setProducts(List<SalableProduct> products) {
     this.products = products;
 }

 // Get the list of products in the inventory.
 public List<SalableProduct> getProducts() {
     return products;
 }

 // Initialize the store inventory with the provided initial inventory.
 public void initializeStoreInventory(List<SalableProduct> initialInventory) {
     this.products = new ArrayList<>(initialInventory);
     System.out.println("Store inventory initialized.");
 }

 // Add new products to the inventory.
 public void addProductsToInventory(List<SalableProduct> newProducts) {
     products.addAll(newProducts);
     System.out.println("Products added to inventory.");
 }

 // Remove a specific product from the inventory.
 public void removeProductFromInventory(SalableProduct product) {
     if (products.contains(product)) {
         products.remove(product);
         System.out.println("Product removed from inventory: " + product.getName());
     } else {
         System.out.println("Product not found in inventory: " + product.getName());
     }
 }

 // Get a copy of the entire inventory.
 public List<SalableProduct> getEntireInventory() {
     return new ArrayList<>(products);
 }

 // Add a single product to the inventory.
 public void addProduct(SalableProduct product) {
     products.add(product);
     System.out.println("Product added to inventory: " + product.getName());
 }

 // Get a copy of the entire inventory (duplicate method).
 public List<SalableProduct> getEntireInventory1() {
     return getEntireInventory();
 }

 // Remove a specific product from the inventory.
 public void removeProduct(SalableProduct product) {
     products.remove(product);
     System.out.println("Product removed from inventory: " + product.getName());
 }

 // Find a product in the inventory by its name, case-insensitive.
 public SalableProduct getProductByName(String name) {
     for (SalableProduct product : products) {
         if (product.getName().equalsIgnoreCase(name)) {
             System.out.println("Product found in inventory: " + product.getName());
             return product;
         }
     }
     System.out.println("Product not found in inventory: " + name);
     return null;
 }
}