package JavaAdvancedExe.catlady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, String breed, double furLength) {
        super(name, breed);
        this.furLength = furLength;
    }

    public String getName() {
        return super.getName();
    }

    public double getFurLength() {
        return furLength;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f", getFurLength());
    }
}
