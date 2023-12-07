package cst239MilestoneProject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileCreator {
    public static void main(String[] args) {
        // Create initial inventory
        List<SalableProduct> initialInventory = new ArrayList<>();
        initialInventory.add(new Weapon("Sword", "A Good Sword, but not great", 29.99, 5, 10));
        initialInventory.add(new Weapon("Bow", "A Sturdy Bow, almost like new", 39.99, 3, 15));
        initialInventory.add(new Armor("Plate Mail", "Heavy armor made of steel plates, this will be difficult to run in", 79.99, 2, 15));
        initialInventory.add(new Armor("Leather Armor", "Light armor made of leather, the shopkeeper will not tell you what kind", 49.99, 4, 20));
        initialInventory.add(new Health("Health Potion", "Restores health points but has a terrible aftertaste", 9.99, 20, 1));

        // Convert the list to JSON format
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(initialInventory);

        // Write JSON to a file
        try (FileWriter writer = new FileWriter("initialInventory.json")) {
            writer.write(json);
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

