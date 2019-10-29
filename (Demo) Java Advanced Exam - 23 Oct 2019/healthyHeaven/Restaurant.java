package JavaAdvancedExams.healthyHeaven;

import java.util.LinkedHashMap;
import java.util.Map;

public class Restaurant {
    private Map<String , Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedHashMap<>();
    }


    public void add(Salad salad){
        this.data.put(salad.getName(),salad);
    }

    public boolean buy(String salad){
        if (this.data.containsKey(salad)){
            this.data.remove(salad);
            return true;
        }
        return false;
    }

    public Salad getHealthiestSalad(){
        int healthiest = Integer.MAX_VALUE;
        String name = "";
        for (Map.Entry<String, Salad> saladEntry : this.data.entrySet()) {
            int current = saladEntry.getValue().getTotalCalories();
            String salad = saladEntry.getKey();
            if (current < healthiest){
                healthiest = current;
                name = salad;
            }
        }

        return this.data.get(name);
    }

    public String generateMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s have %d salads:%n",this.name,this.data.size()));
        this.data.values().forEach(e -> stringBuilder.append(e.toString()).append(System.getProperty("line.separator")));

        return stringBuilder.toString().trim();
    }
}
