package javaoopexe.pizzacalories;

import java.util.Arrays;
import java.util.List;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        List<String> arr = Arrays.asList("Meat", "Veggies", "Cheese", "Sauce");
        if (!arr.contains(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return ToppingsModifiers.valueOf(this.toppingType.toUpperCase()).getValue() * (this.weight * 2);
    }
}
