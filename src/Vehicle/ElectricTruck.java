package Vehicle;

public class ElectricTruck extends Truck{
    //variables
    private double maxAuto;

    //default
    public ElectricTruck(){
        super();
    }

    //constructor
    public ElectricTruck(String make, String model, int year, String type, double capacity, double maxAuto){
        super(make, model, year, "ElectricTruck", capacity);
        this.maxAuto = maxAuto;
    }

    //copy
    public ElectricTruck(ElectricTruck other){
        super(other.getMake(), other.getModel(), other.getYear(), "ElectricTruck", other.getCapacity());
        this.maxAuto = other.maxAuto;
    }

    //getters
    public double getMaxAuto() {
        return maxAuto;
    }

    //setters
    public void setMaxAuto(double maxAuto) {
        this.maxAuto = maxAuto;
    }

    //toString
    @Override
    public String toString(){
        return super.toString() + " \nMax Autonomy Range: " + this.maxAuto + " miles";
    }

    //equals
    @Override
    public boolean equals(Object o){
        ElectricTruck eTruck = (ElectricTruck) o;
        return super.equals(o) && (this.maxAuto == eTruck.maxAuto);
    }
}
