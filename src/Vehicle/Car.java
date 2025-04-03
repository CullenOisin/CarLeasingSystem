package Vehicle;

public abstract class Car extends Vehicle{
    //variables
    private int numPass;

    //default
    public Car(){
        super();
    }

    //constructor
    public Car(String make, String model, int year, String type, int numPass){
        super(make, model, year, type);
        this.numPass = numPass;
    }

    //copy
    public Car(Car other){
        super(other.getMake(), other.getModel(), other.getYear(), other instanceof ElectricCar ? "ElectricCar" : "GasCar");
        this.numPass = other.numPass;
    }

    //getter
    public int getNumPass() {
        return numPass;
    }

    //setter
    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + " \nMax Passengers: " + this.numPass;
    }

    @Override
    public boolean equals(Object o){
        Car car = (Car) o;
        return super.equals(o) && (numPass == car.numPass);
    }
}
