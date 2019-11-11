package javaoopexe.pizzacalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaType = reader.readLine().split("\\s+");
        String pizzaName = pizzaType[1];
        int numberOfToppings = Integer.parseInt(pizzaType[2]);

        String[] doughType = reader.readLine().split("\\s+");
        String flourType = doughType[1];
        String technique = doughType[2];
        double weight = Double.parseDouble(doughType[3]);
        Pizza pizza = null;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(flourType, technique, weight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String input = "";
        while (!"END".equals(input = reader.readLine())) {
            String[] toppings = input.split("\\s+");

            try {
                Topping topping = new Topping(toppings[1], Double.parseDouble(toppings[2]));
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        System.out.println(pizza.toString());

    }
}
