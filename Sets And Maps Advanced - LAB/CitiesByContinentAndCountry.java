package JavaAdvancedLabs;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continentCountryCities = new LinkedHashMap<>();

        int n = Integer.parseInt(in.nextLine());

        while (n-- > 0) {
            String[] input = in.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continentCountryCities.putIfAbsent(continent, new LinkedHashMap<>());
            continentCountryCities.get(continent).putIfAbsent(country, new LinkedList<>());
            continentCountryCities.get(continent).get(country).add(city);

        }

        continentCountryCities.entrySet().stream().forEach(e -> {
            System.out.printf("%s:\n", e.getKey());
            e.getValue().entrySet().stream().forEach(w -> {

                System.out.println("    "+w.getKey() + " -> " + String.join(", ", w.getValue()));
            });
        });

    }
}
