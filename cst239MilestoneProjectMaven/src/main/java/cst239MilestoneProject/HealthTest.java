package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// HealthTest class contains JUnit tests for the Health class.
public class HealthTest {

    // Test case to ensure that the Health constructor sets attributes correctly.
    @Test
    public void testHealth() {
        // Create a Health instance with specific attributes.
        Health health = new Health("TestHealth", "TestDescription", 30.0, 8, 5);

        // Check if the attributes are set as expected using assertEquals statements.
        assertEquals("TestHealth", health.getName());
        assertEquals("TestDescription", health.getDescription());
        assertEquals(30.0, health.getPrice(), 0.001);
        assertEquals(8, health.getQuantity());
    }

    // Additional test cases for other methods in the Health class can be added if needed.
}