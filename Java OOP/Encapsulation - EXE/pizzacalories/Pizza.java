package javaoopexe.pizzacalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(this.numberOfToppings);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15 || name==null) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;

    }

    public void addTopping(Topping topping) {
        if(this.toppings.size() < this.numberOfToppings){
            this.toppings.add(topping);
        }
    }

    public double getOverallCalories() {
        double sum = 0;
        for (Topping topping : this.toppings) {
            sum += topping.calculateCalories();
        }

        return this.dough.calculateCalories() + sum;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }
}
