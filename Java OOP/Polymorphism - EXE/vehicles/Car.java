package vehicles;

public class Car extends Vehicle  {

    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + 0.9);
    }


}
