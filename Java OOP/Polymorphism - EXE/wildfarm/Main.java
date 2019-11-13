package javaoopexe.wildfarm;

import javaoopexe.wildfarm.food.Food;
import javaoopexe.wildfarm.food.Meat;
import javaoopexe.wildfarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";
        List<Animal> animals = new LinkedList<>();

        while (!"End".equals(command = reader.readLine())) {
            String[] animal = command.split("\\s+");
            String type = animal[0];
            String name = animal[1];
            Double weight = Double.parseDouble(animal[2]);
            String region = animal[3];

            String breed = null;
            if (type.equals("Cat")) {
                breed = animal[4];
            }

            Animal animal1 = null;

            String[] foods = reader.readLine().split("\\s+");
            String typeFood = foods[0];
            Integer quantity = Integer.parseInt(foods[1]);

            Food food = null;
            if (typeFood.equals("Vegetable")) {
                food = new Vegetable(quantity);
            } else {
                food = new Meat(quantity);
            }

            switch (type) {
                case "Mouse":
                    animal1 = new Mouse(type, name, weight, region);
                    break;
                case "Zebra":
                    animal1 = new Zebra(type, name, weight, region);
                    break;
                case "Tiger":
                    animal1 = new Tiger(type, name, weight, region);
                    break;
                case "Cat":
                    animal1 = new Cat(type, name, weight, region, breed);
                    break;
            }

            if (animal1 != null) {
                animal1.makeSound();
                try {
                    animal1.eatFood(food);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            animals.add(animal1);

        }

        animals.forEach(System.out::println);
    }
}
