package Automobile;

public class Automobile {
  public String make;
  public String model;
  public String color;
  public int year;
  public int mileage;

  // Default constructor.
  public Automobile() {
    this.make = "";
    this.model = "";
    this.color = "";
    this.year = 0;
    this.mileage = 0;
  }

  // Parameterized constructor
  public Automobile(String make, String model, 
    String color, int year, int mileage) {
    this.make = make;
    this.model = model;
    this.color = color;
    this.year = year;
    this.mileage = mileage;
  }

  // List vehicle information (return string array)
  public String[] listVehicleInformation() {
    try {
      String[] vehicleInformation = new String[] {
          this.make, this.model, this.color, String.valueOf(this.year),
          String.valueOf(this.mileage) };
      return vehicleInformation;
    } catch (Exception e) {
      String failureMessage =
        "Failed to list vehicle information.";
      return new String[] { failureMessage };
    }
  }
}