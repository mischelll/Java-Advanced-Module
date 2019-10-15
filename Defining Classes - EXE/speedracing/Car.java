package JavaAdvancedExe.speedracing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distance;

    public Car(String model, double fuelAmount, double fuelCostPerKm){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public int getDistance() {
        return distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount -= fuelAmount * getFuelCostPerKm();
    }

    public void addDistance(double distance) {
        this.distance += distance;
    }

    public boolean drive(double amoutOfKm){
        if (amoutOfKm * getFuelCostPerKm() <= getFuelAmount()){

            return true;
        }
        return false;
    }

    public String toString(){
        return String.format("%s %.2f %d%n",getModel(),getFuelAmount(),getDistance());
    }
}
