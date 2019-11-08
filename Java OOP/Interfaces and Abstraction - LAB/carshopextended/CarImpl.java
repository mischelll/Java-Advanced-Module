package javaooplabs.carshopextended;

public class CarImpl  implements  Car{
    protected String model;
    protected String color;
    protected Integer horsePower;
    protected String country;

    public CarImpl(String model, String color, Integer horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                getModel(),
                countryProduced(),
                TIRES);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.country;
    }
}
