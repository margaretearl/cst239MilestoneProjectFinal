package cst239MilestoneProject;

//Margo Earl
//CST239
//Milestone 7
//12/3/23-12/10/23
//This is my own work

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// CommandProcessor class handles processing commands received from the network.
public class CommandProcessor {
    private StoreFront storeFront;

    // Constructor to initialize the CommandProcessor with a StoreFront instance.
    public CommandProcessor(StoreFront storeFront) {
        this.storeFront = storeFront;
    }

    // Process the incoming command string.
    public void processCommand(String command) {
        Gson gson = new Gson();

        try {
            // Convert the incoming command string to a CommandData object.
            CommandData commandData = gson.fromJson(command, CommandData.class);

            // Switch case to handle different types of commands.
            switch (commandData.getCommand()) {
                case "U":
                    // Update Store Front inventory with new Salable Products.
                    updateInventory(commandData.getData());
                    break;
                case "R":
                    // Return all Salable Products from the Store Front Inventory in JSON format.
                    returnInventory();
                    break;
                default:
                    System.out.println("Unknown command: " + commandData.getCommand());
            }
        } catch (Exception e) {
            System.out.println("Error processing command: " + e.getMessage());
        }
    }

    // Update the inventory based on the JSON data received.
    private void updateInventory(String jsonData) {
        // Convert JSON data to a list of SalableProduct objects.
        Gson gson = new Gson();
        List<SalableProduct> newProducts = gson.fromJson(jsonData, new TypeToken<List<SalableProduct>>() {}.getType());

        // Update the inventory.
        storeFront.addProductsToInventory(newProducts);
        System.out.println("Store Front inventory updated.");
    }

    // Return the entire inventory in JSON format.
    private void returnInventory() {
        // Get the entire inventory and convert it to JSON format.
        List<SalableProduct> inventory = storeFront.getEntireInventory();
        Gson gson = new Gson();
        String jsonData = gson.toJson(inventory);

        // Send the JSON data to the Admin User or display it on the console.
        System.out.println("Sending inventory to Admin User:");
        System.out.println(jsonData);
    }

    // CommandData class represents the structure of a command containing command type and data.
    private static class CommandData {
        private String command;
        private String data;

        public String getCommand() {
            return command;
        }

        public String getData() {
            return data;
        }
    }

    // Send a command to the server using a socket connection.
    public void sendCommand(String command) {
        try {
            Socket socket = new Socket("localhost", 9876); // Connect to the server on localhost.
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(command);
            out.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}