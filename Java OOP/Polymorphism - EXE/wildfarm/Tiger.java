package javaoopexe.wildfarm;

import javaoopexe.wildfarm.food.Food;
import javaoopexe.wildfarm.food.Meat;

public class Tiger extends Felime {


    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
   public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if (food instanceof Meat){
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }else {
            throw new IllegalArgumentException(String.format("Tigers are not eating that type of food!"));
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
