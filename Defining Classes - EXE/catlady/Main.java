package JavaAdvancedExe.catlady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        Map<String, Cat> catMap = new LinkedHashMap<>();
        while (!"End".equals(input = reader.readLine())) {
            String[] data = input.split("\\s+");

            String breed = data[0];
            if (breed.equals("StreetExtraordinaire")) {
                catMap.put(data[1], new StreetExtraordinaire(data[1], data[0], Double.parseDouble(data[2])));
            } else if (breed.equals("Siamese")) {
                catMap.put(data[1], new Siamese(data[0], data[1], Double.parseDouble(data[2])));
            } else {
                catMap.put(data[1], new Cymric(data[1], data[0], Double.parseDouble(data[2])));
            }
        }

        String name = reader.readLine();
        if (catMap.containsKey(name)){
            System.out.println(catMap.get(name).toString());
        }
    }
}
