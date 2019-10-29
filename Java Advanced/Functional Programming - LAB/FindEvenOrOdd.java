package JavaAdvancedLabs;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] split = in.nextLine().split(" ");
        String evenOrOdd = in.nextLine();
        int lowerBound = Integer.parseInt(split[0]);
        int upperBound = Integer.parseInt(split[1]);

        Predicate<Integer> filterEven = num -> num % 2 == 0;
        Predicate<Integer> filterOdd = num -> num % 2 != 0;

        Predicate<Integer> byType = filterEven;
        if (evenOrOdd.equals("odd")){
            byType = filterOdd;
        }

         IntStream
                .range(lowerBound,upperBound + 1)
                .boxed()
                .filter(byType)
                .forEach(x -> System.out.print(x + " "));
    }
}
