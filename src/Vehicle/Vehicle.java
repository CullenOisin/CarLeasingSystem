package Vehicle;

import java.util.Objects;

public abstract class Vehicle {
    //variables
    private String plateNum;
    private String make;
    private String model;
    private int year;
    private static int ec = 1001, et = 1001, gc = 1001, dt = 1001;


    //Default constructor
    public Vehicle(){
        this.make = "None";
        this.model = "None";
        this.year = 0000;
        this.plateNum = "__0000";
    }

    //Constructor
    public Vehicle(String make, String model, int year, String type){
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNum = generatePlateNum(type);
    }

    //Copy constructor
    public Vehicle(Vehicle other){
        this.make = other.make;
        this.model = other.model;
        this.year = other.year;
        this.plateNum = other.plateNum;
    }

    private String generatePlateNum(String type){
        switch(type){
            case "ElectricCar": return "EC" + (ec++);

            case "ElectricTruck": return "ET" + (et++);

            case "GasCar": return "GC" + (gc++);

            case "DieselTruck": return "DT" + (dt++);

            default: return "Invalid Vehicle Type";
        }
    }

    //getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getPlateNum() {
        return plateNum;
    }

    //setters

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //toString
    @Override
    public String toString(){
        return "Make: " + make + " \nModel: " + model + " \nYear: " + year + " \nPlate: " + plateNum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model);
    }


}
