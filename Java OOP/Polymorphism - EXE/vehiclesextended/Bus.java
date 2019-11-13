package javaoopexe.vehicles;

public class Bus extends Vehicle {
    public static final double BUS_WITH_PEOPLE_CONSUMPT = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + BUS_WITH_PEOPLE_CONSUMPT, tankCapacity);
    }


}
