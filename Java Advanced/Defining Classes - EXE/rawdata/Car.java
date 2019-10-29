package JavaAdvancedExe.rawdata;

import java.util.List;

public class Car {
    public final static int TIRES_COUNT = 4;
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public String getModel() {
        return model;
    }

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }
}
