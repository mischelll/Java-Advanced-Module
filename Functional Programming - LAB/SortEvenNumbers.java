package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] split = in.nextLine().split(", ");

        List<String> evenNums = Arrays.stream(split)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNums));

        List<String> sortedNums = evenNums.stream()
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", sortedNums));
    }
}
