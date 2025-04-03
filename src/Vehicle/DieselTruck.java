package Vehicle;

public class DieselTruck extends Truck{
    //varibales
    private double fuelTank;

    //default
    public DieselTruck(){
        super();
    }

    //constructor
    public DieselTruck(String make, String model, int year, String type, double capacity, double fuelTank){
        super(make, model, year, "DieselTruck", capacity);
        this.fuelTank = fuelTank;
    }

    //copy
    public DieselTruck(DieselTruck other){
        super(other.getMake(), other.getModel(), other.getYear(), "DieselTruck",other.getCapacity());
        this.fuelTank = other.fuelTank;
    }

    //getters
    public double getFuelTank() {
        return fuelTank;
    }

    //setters
    public void setFuelTank(double fuelTank) {
        this.fuelTank = fuelTank;
    }

    //toString
    @Override
    public String toString(){
        return super.toString() + " \nFuel Capacity: " + this.fuelTank + " gallons";
    }

    //equals
    @Override
    public boolean equals(Object o){
        DieselTruck dTruck = (DieselTruck) o;
        return super.equals(o) && (this.fuelTank == dTruck.fuelTank);
    }

}
