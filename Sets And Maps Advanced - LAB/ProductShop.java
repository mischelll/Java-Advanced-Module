package JavaAdvancedLabs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Map<String, Double>> shopProductPrice =  new TreeMap<>();

        String command;
        while (!"Revision".equals(command = in.nextLine())){
            String[] data = command.split(",\\s+");

            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            shopProductPrice.putIfAbsent(shop,new LinkedHashMap<>());
            shopProductPrice.get(shop).put(product,price);
        }

        shopProductPrice.entrySet().stream().forEach(e -> {
            System.out.printf("%s->\n",e.getKey());
            e.getValue().entrySet().stream().forEach(w -> {
                System.out.printf("Product: %s, Price: %.1f\n",w.getKey(),w.getValue());
            });
        });

    }
}
