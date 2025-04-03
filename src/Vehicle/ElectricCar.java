package Vehicle;

public class ElectricCar extends Car{
    //variables
    private double maxAutoC;

    //default
    public ElectricCar(){
        super();
    }

    //constructor
    public ElectricCar(String make, String model, int year, String type, int numPass, double maxAutoC){
        super(make, model, year, "ElectricCar", numPass);
        this.maxAutoC = maxAutoC;
    }

    //copy
    public ElectricCar(ElectricCar other){
        super(other.getMake(), other.getModel(), other.getYear(), "ElectricCar", other.getNumPass());
        this.maxAutoC = other.maxAutoC;
    }

    //getters
    public double getMaxAutoC() {
        return maxAutoC;
    }

    //setters
    public void setMaxAutoC(double maxAutoC) {
        this.maxAutoC = maxAutoC;
    }

    //toString
    @Override
    public String toString(){
        return super.toString() + " \nMax Autonomy Range: " + this.maxAutoC;
    }

    //equals
    @Override
    public boolean equals(Object o){
        ElectricCar eCar = (ElectricCar) o;
        return super.equals(o) && (this.maxAutoC == eCar.maxAutoC);
    }
}
