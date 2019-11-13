package javaoopexe.vehicles;

public class Car extends Vehicle  {


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity + 0.9);
    }
}
