package JavaAdvancedExe.catlady;

public class StreetExtraordinaire extends Cat {
    private double decibels;

    public StreetExtraordinaire(String name, String breed, double decibels) {
        super(name, breed);
        this.decibels = decibels;
    }

    public String getName() {
        return super.getName();
    }

    public double getDecibels() {
        return decibels;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", getDecibels());
    }
}
