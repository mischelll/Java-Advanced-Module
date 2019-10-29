package JavaAdvancedExams.healthyHeaven;

import java.util.LinkedHashMap;
import java.util.Map;

public class Salad {
    private String name;
    private Map<String, Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getTotalCalories(){
        return products
                .values()
                .stream()
                .mapToInt(Vegetable::getCalories)
                .sum();
    }

    public int getProductCount(){
        return this.products.size();
    }

    public void add(Vegetable vegetable){
        this.products.put(vegetable.getName(),vegetable);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("* Salad %s is %d calories and have %d products:%n", getName(),getTotalCalories(),getProductCount()));
        this.products.values().forEach(e -> stringBuilder.append(e.toString()).append(System.getProperty("line.separator")));

        return stringBuilder.toString().trim();
    }
}
