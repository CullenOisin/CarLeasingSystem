package Vehicle;

public class GasCar extends Car{
    //default
    public GasCar(){
        super();
    }

    //constructor
    public GasCar(String make, String model, int year, String type, int numPass){
        super(make, model, year, "GasCar", numPass);
    }

    //copy
    public GasCar(GasCar other){
        super(other.getMake(), other.getModel(), other.getYear(), "GasCar", other.getNumPass());
    }

    //toString
    @Override
    public String toString(){
        return super.toString();
    }

    //equals
    @Override
    public boolean equals(Object o){
        GasCar gCar = (GasCar) o;
        return super.equals(o);
    }
}
