package JavaAdvancedExe.catlady;

public class Siamese extends Cat {
    private double earSize;

    public Siamese(String name, String breed, double earSize) {
        super(name, breed);
        this.earSize = earSize;
    }

    public String getName() {
        return super.getName();
    }

    public double getEarSize() {
        return earSize;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", getEarSize());
    }
}
