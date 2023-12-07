package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// SalableProductTest class contains JUnit tests for the SalableProduct class.
public class SalableProductTest {

    // Test case to ensure that the SalableProduct constructor sets attributes correctly.
    @Test
    public void testSalableProduct() {
        // Create a SalableProduct instance with specific attributes.
        SalableProduct product = new SalableProduct("TestProduct", "TestDescription", 20.0, 5);

        // Check if the attributes are set as expected using assertEquals statements.
        assertEquals("TestProduct", product.getName());
        assertEquals("TestDescription", product.getDescription());
        assertEquals(20.0, product.getPrice(), 0.001);
        assertEquals(5, product.getQuantity());
    }

    // Test case to ensure that the setQuantity method updates the quantity attribute.
    @Test
    public void testSetQuantity() {
        // Create a SalableProduct instance with specific attributes.
        SalableProduct product = new SalableProduct("TestProduct", "TestDescription", 20.0, 5);

        // Set a new quantity using the setQuantity method.
        product.setQuantity(10);

        // Check if the quantity is updated as expected using assertEquals.
        assertEquals(10, product.getQuantity());
    }

    // Additional test cases for other getters and setters can be added as needed.
}