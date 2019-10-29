package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] prices = in.nextLine().split(", ");

        UnaryOperator<Double> VAT = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(VAT)
                .forEach(x -> System.out.printf("%.2f%n",x));



    }
}
