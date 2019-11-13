package javaoopexe.wildfarm;

import javaoopexe.wildfarm.food.Food;
import javaoopexe.wildfarm.food.Vegetable;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }


    @Override
    public void eatFood(Food food) {
        String resultType = this.getClass().getSimpleName().equals("Mouse") ?  "Mice" : "Zebras";
        if (food instanceof Vegetable){
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }else {
            throw new IllegalArgumentException(String.format("%s are not eating that type of food!",resultType));
        }
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                format.format(getAnimalWeight()),
                this.livingRegion,
                getFoodEaten());

    }
}
