package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

// Importing static methods from the Assert class for better code readability.
import static org.junit.Assert.assertEquals;
import org.junit.Test;

// ArmorTest class contains JUnit tests for the Armor class.
public class ArmorTest {

    // Test case to ensure that the Armor constructor sets attributes correctly.
    @Test
    public void testArmor() {
        // Create an Armor instance with specific attributes.
        Armor armor = new Armor("TestArmor", "TestDescription", 40.0, 2, 15);

        // Check if the attributes are set as expected using assertEquals statements.
        assertEquals("TestArmor", armor.getName());
        assertEquals("TestDescription", armor.getDescription());
        assertEquals(40.0, armor.getPrice(), 0.001);
        assertEquals(2, armor.getQuantity());
    }

    // Additional test cases for other methods in the Armor class can be added if needed.
}