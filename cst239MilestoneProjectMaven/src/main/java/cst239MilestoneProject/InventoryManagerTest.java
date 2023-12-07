package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InventoryManagerTest {

    private InventoryManager inventoryManager;
    // Set up a new InventoryManager instance before each test.
    @Before
    public void setUp() {
        inventoryManager = new InventoryManager();
    }
    // Test adding a product to the inventory.
    @Test
    public void testAddProductToInventory() {
        SalableProduct product = new SalableProduct("TestProduct", "TestDescription", 20.0, 5);
        inventoryManager.addProduct(product);

        List<SalableProduct> inventory = inventoryManager.getEntireInventory();
        assertEquals(1, inventory.size());
        assertEquals(product, inventory.get(0));
    }
    // Test removing a product from the inventory
    @Test
    public void testRemoveProductFromInventory() {
        SalableProduct product = new SalableProduct("TestProduct", "TestDescription", 20.0, 5);
        inventoryManager.addProduct(product);
        // Remove the product and verify that the inventory is empty.
        inventoryManager.removeProduct(product);

        List<SalableProduct> inventory = inventoryManager.getEntireInventory();
        assertEquals(0, inventory.size());
    }
    // Test retrieving a product from the inventory by name.
    @Test
    public void testGetProductByName() {
        SalableProduct product = new SalableProduct("TestProduct", "TestDescription", 20.0, 5);
        inventoryManager.addProduct(product);
        // Retrieve the product by name and verify it matches the added product.
        SalableProduct retrievedProduct = inventoryManager.getProductByName("TestProduct");

        assertEquals(product, retrievedProduct);
    }
    // Test retrieving a non-existent product from the inventory by name.
    @Test
    public void testGetProductByNameNotFound() {
        SalableProduct retrievedProduct = inventoryManager.getProductByName("NonExistentProduct");
        assertNull(retrievedProduct);
    }

    // Add more test cases if needed
}
