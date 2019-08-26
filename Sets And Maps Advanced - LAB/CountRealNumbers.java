package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double[] numbers =
                Arrays.stream(in.nextLine().split("\\s+"))
                        .mapToDouble(Double::parseDouble)
                        .toArray();

        Map<Double, Integer> keyValue = new LinkedHashMap<>();


        for (double number : numbers) {
            if (!keyValue.containsKey(number)) {
                keyValue.put(number, 1);
            } else {
                keyValue.put(number, keyValue.get(number) + 1);
            }
        }

        keyValue.entrySet().stream().forEach(e -> System.out.printf("%.1f -> %d\n", e.getKey(), e.getValue()));

    }
}
