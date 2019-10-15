package JavaAdvancedExe.google;

public class Car {
    private String model;
    private int speed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    @Override
    public String toString(){
        return String.format("%s %d%n",getModel(),getSpeed());
    }
}
