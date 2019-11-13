package javaoopexe.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double km) {
        DecimalFormat format = new DecimalFormat("#.##");
        if (this.fuelConsumption * km <= this.fuelQuantity) {
            this.fuelQuantity -= this.fuelConsumption * km;
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), format.format(km));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    public void driveEmptyBus(double km) {
        DecimalFormat format = new DecimalFormat("#.##");
        if (this.fuelConsumption * km <= this.fuelQuantity) {
            this.fuelConsumption -= Bus.BUS_WITH_PEOPLE_CONSUMPT;
            this.fuelQuantity -= this.fuelConsumption * km;
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), format.format(km));
        } else {
            System.out.printf("%s needs refueling%n", this.getClass().getSimpleName());
        }
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.printf("Fuel must be a positive number%n");
        } else {
            if (this.fuelQuantity + liters > this.tankCapacity) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                this.fuelQuantity += liters;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
}
