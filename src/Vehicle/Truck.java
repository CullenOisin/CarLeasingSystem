package Vehicle;

public abstract class Truck extends Vehicle{
    //varibles
    private double capacity;

    //Default
    public Truck(){
        super();
    }

    //Constructor
    public Truck(String make, String model, int year, String type, double capacity){
        super(make, model, year, type);
        this.capacity = capacity;
    }

    //Copy constructor
    public Truck(Truck other){
        super(other.getMake(), other.getModel(), other.getYear(), other instanceof ElectricTruck ? "ElectricTruck" : "DieselTruck");
        this.capacity = other.capacity;
    }

    //getters
    public double getCapacity(){
        return capacity;
    }

    //setters
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    //toString
    @Override
    public String toString(){
        return super.toString() + " \nMax Capacity: " + capacity + " lbs";
    }

    //equals
    @Override
    public boolean equals(Object o){
        Truck truck = (Truck) o;
        return super.equals(o) && (this.capacity == truck.capacity);
    }
}
