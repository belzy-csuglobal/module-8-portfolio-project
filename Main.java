import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import Automobile.Automobile;

public class Main {
  public static Scanner scanner = new Scanner(System.in);
  public static Automobile automobile;
  public static String[] attributes;
  public static String message;
  public static String[] keys = new String[] { 
    "Make", "Model", "Color", "Year", "Mileage" };

 // Add a new vehicle method
 public static String addNewVehicle() {
    try {
      String successMessage = 
        "Successfully added new vehicle.";

      // Create new vehicle.
      automobile = new Automobile(
        "Tesla", "Model S", "Red", 2023, 50000);

      return successMessage;
    } catch (Exception e) {
      String failureMessage = 
        "Failed to add new vehicle.";
      return failureMessage;
    }
  }

  // Remove a vehicle method
  public static String removeVehicle() {
    try {
      String successMessage = 
        "Seccuessfly removed vehicle.";

      // Clear the variables.
      automobile.make = "";
      automobile.model = "";
      automobile.color = "";
      automobile.year = 0;
      automobile.mileage = 0;

      return successMessage;
    } catch (Exception e) {
      String failureMessage = 
        "Failed to remove vehicle.";
      return failureMessage;
    }
  }

  // Update vehicle attributes method.
  public static String updateVehicleAttributes(
    String make, String model, String color, int year, int mileage) {
    try {
      String successMessage =
        "Successfully updated vehicle.";

      // Update vehicle attributes.
      automobile.make = make;
      automobile.model = model;
      automobile.color = color;
      automobile.year = year;
      automobile.mileage = mileage;

      return successMessage;
    } catch (Exception e) {
      String failureMessage = 
        "Failed to update vehicle.";
      return failureMessage;
    }
  }

  // Print the vehicle information to a file.
  public static String printToFile() {
    try {
      String successMessage =
        "Successfully printed to file.";

      File file = new File("C:\\Temp\\Autos.txt");
      BufferedWriter writer = 
        new BufferedWriter(new FileWriter(file));

      // Call the list method.
      attributes = automobile.listVehicleInformation();

      // Loop through the array and write.
      for (int i = 0; i < attributes.length; i++) {
        writer.write(String.format("%s: %s\n", keys[i], attributes[i]));
      }

      // Close the writer.
      writer.close();
      return successMessage;
    } catch (Exception e) {
      String failureMessage =
        "Failed to print to file.";
      return failureMessage;
    }
  }

  public static void main(String[] args) {
    try {
      // Call parameterized constructor.
      automobile = 
        new Automobile(
          "Subaru", "BRZ", "Black", 2023, 50000);

      // Call the method to list the values. 
      attributes = automobile.listVehicleInformation();

      // Loop through the array and print to the screen.
      for (int i = 0; i < attributes.length; i++) {
        System.out.printf("%s: %s\n", keys[i], attributes[i]);
      }

      // Call the remove vehicle method to clear the variables.
      message = removeVehicle();

      // Print the return value.
      System.out.println("\n" + message);

      // Add a new vehicle.
      message = addNewVehicle();

      // Print the return value.
      System.out.println("\n" + message + "\n");

      // Call the list method and print the new vehicle information to the screen.
      attributes = automobile.listVehicleInformation();

      // Loop through the array and print to the screen.
      for (int i = 0; i < attributes.length; i++) {
        System.out.printf("%s: %s\n", keys[i], attributes[i]);
      }

      // Update the vehicle.
      message = updateVehicleAttributes(
        "Jeep", "Wrangler", "Yellow", 2005, 250000);

      // Print the return value.
      System.out.println("\n" + message + "\n");

      // Call the list method and print the new vehicle information to the screen.
      attributes = automobile.listVehicleInformation();

      // Loop through the array and print to the screen.
      for (int i = 0; i < attributes.length; i++) {
        System.out.printf("%s: %s\n", keys[i], attributes[i]);
      }

      // Display a message asking if the user wants to print 
      // the information to a file (Y or N).
      System.out.println(
        "\nDo you want to print the information to a file? (Y or N)");

      // Use a scanner to capture the response.  
      String response = scanner.nextLine();
      
      // If "Y", print the file to a predefined location.
      if (response.equals("Y")) {
        printToFile();
      }

      // If "N", indicate that a file will not be printed.
      if (response.equals("N")) {
        System.out.println("The file will not be printed.");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}