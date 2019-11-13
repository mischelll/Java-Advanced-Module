package javaoopexe.wildfarm;

import javaoopexe.wildfarm.food.Food;
import javaoopexe.wildfarm.food.Meat;
import javaoopexe.wildfarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }


    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                this.breed,
                format.format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }

    public static class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String command = "";
            List<Animal> animals = new ArrayList<>();

            while (!"End".equals(command = reader.readLine())) {
                String[] animal = command.split("\\s+");
                String type = animal[0];
                String breed = null;
                if (type.equals("Cat")) {
                    breed = animal[4];
                }
                String name = animal[1];
                Double weight = Double.parseDouble(animal[2]);
                String region = animal[3];

                String[] food = reader.readLine().split("\\s+");
                String foodType = food[0];
                Integer quantity = Integer.parseInt(food[1]);

                Food food1 = null;
                if (foodType.equals("Vegetable")) {
                    food1 = new Vegetable(quantity);
                } else {
                    food1 = new Meat(quantity);
                }

                switch (type) {
                    case "Mouse":
                        Animal mouse = new Mouse(name, type, weight, region);
                        mouse.makeSound();
                        animals.add(mouse);
                        try {
                            mouse.eatFood(food1);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Tiger":
                        Animal tiger = new Tiger(name, type, weight, region);
                        tiger.makeSound();
                        animals.add(tiger);
                        try {
                            tiger.eatFood(food1);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case "Cat":
                        Animal cat = new Cat(name, type, weight, region, breed);
                        cat.makeSound();
                        cat.eatFood(food1);
                        animals.add(cat);
                        break;

                    case "Zebra":
                        Animal zebra = new Zebra(name, type, weight, region);
                        zebra.makeSound();
                        animals.add(zebra);

                        try {
                            zebra.eatFood(food1);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }

            }

            animals.forEach(System.out::println);
        }
    }
}
