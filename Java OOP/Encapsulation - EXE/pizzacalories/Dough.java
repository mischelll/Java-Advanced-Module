package javaoopexe.pizzacalories;

import java.util.Arrays;
import java.util.List;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        List<String> doughTypes = Arrays.asList("White", "Wholegrain");
        if (!doughTypes.contains(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        List<String> techniques = Arrays.asList("Crispy", "Chewy", "Homemade");
        if (!techniques.contains(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return DoughModifiers.valueOf(this.flourType.toUpperCase()).getValue()
                * DoughModifiers.valueOf(this.bakingTechnique.toUpperCase()).getValue()
                * (2 * this.weight);
    }


}
