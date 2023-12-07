package cst239MilestoneProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileServer {
    // Method to read JSON inventory data from a file
    public static List<SalableProduct> readInventoryFromFile(String filePath) throws IOException {
        String jsonData = Files.readString(Path.of(filePath));
        Gson gson = new Gson();
        return gson.fromJson(jsonData, new TypeToken<List<SalableProduct>>() {}.getType());
    }

    // Method to write JSON inventory data to a file
    public static void writeInventoryToFile(List<SalableProduct> inventory, String filePath) throws IOException {
        Gson gson = new Gson();
        String jsonData = gson.toJson(inventory);
        Files.write(Path.of(filePath), jsonData.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}