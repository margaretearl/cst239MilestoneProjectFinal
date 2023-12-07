package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// WeaponTest class contains JUnit tests for the Weapon class.
public class WeaponTest {

    // Test case to ensure that the Weapon constructor sets attributes correctly.
    @Test
    public void testWeapon() {
        // Create a Weapon instance with specific attributes.
        Weapon weapon = new Weapon("TestWeapon", "TestDescription", 50.0, 3, 10);

        // Check if the attributes are set as expected using assertEquals statements.
        assertEquals("TestWeapon", weapon.getName());
        assertEquals("TestDescription", weapon.getDescription());
        assertEquals(50.0, weapon.getPrice(), 0.001);
        assertEquals(3, weapon.getQuantity());
    }

    // Additional test cases for other methods in the Weapon class can be added if needed.
}