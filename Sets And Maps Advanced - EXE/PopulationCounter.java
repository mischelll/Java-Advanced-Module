package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> countryCityPopulation = new LinkedHashMap<>();
        Map<String, Long> countryPopulation = new LinkedHashMap<>();

        String input = "";

        while (!"report".equals(input = bf.readLine())){
            String[] data = input.split("\\|");

            String city = data[0];
            String country = data[1];
            long population = Integer.parseInt(data[2]);

            countryCityPopulation.putIfAbsent(country, new LinkedHashMap<>());
            countryCityPopulation.get(country).putIfAbsent(city,0L);
            countryCityPopulation.get(country).put(city,countryCityPopulation.get(country).get(city) + population);

            countryPopulation.putIfAbsent(country, 0L);
            countryPopulation.put(country,countryPopulation.get(country) + population);
        }

        countryPopulation
                .entrySet()
                .stream()
                .sorted((a,b) -> Long.compare(b.getValue(),a.getValue()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n",e.getKey(),e.getValue());
                    countryCityPopulation.get(e.getKey()).entrySet().stream().sorted((x,y) -> Long.compare(y.getValue(),x.getValue())).forEach(w -> {
                        System.out.printf("=>%s: %d%n",w.getKey(),w.getValue());
                    });
                });
    }
}
