package javaoopexe.shoppingspree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = reader.readLine().replace("=", " ").replace(";", " ");
        String input2 = reader.readLine().replace("=", " ").replace(";", " ");

        Map<String, Person> personMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new LinkedHashMap<>();

        String[] nameMoney = input1.split("\\s+");
        for (int i = 0; i < nameMoney.length; i += 2) {
            String name = nameMoney[i];
            double money = Double.parseDouble(nameMoney[i + 1]);
            try {
                Person person = new Person(name, money);
                personMap.put(person.getName(),person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] productCost = input2.split("\\s+");
        for (int i = 0; i < productCost.length; i += 2) {
            String name = productCost[i];
            double cost = Double.parseDouble(productCost[i + 1]);
            try {
                Product product = new Product(name, cost);
                productMap.put(product.getName(),product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = "";
        while (!"END".equals(command = reader.readLine())){
            String[] data = command.split("\\s+");
            String personName = data[0];
            String productName = data[1];

            if (personMap.get(personName).canBeBought(productMap.get(productName))){
                personMap.get(personName).buyProduct(productMap.get(productName));
                System.out.printf("%s bought %s%n",personName,productName);
            }else {
                System.out.printf("%s can't afford %s%n",personName,productName);
            }
        }

        personMap.entrySet().stream().forEach(e -> System.out.println(e.getValue().toString()) );

    }
}
