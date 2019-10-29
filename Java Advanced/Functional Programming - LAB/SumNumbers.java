package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] split = in.nextLine().split(", ");
        Function<String, Integer> parse = Integer::parseInt;

        List<Integer> nums = Arrays.stream(split)
                .map(parse)
                .collect(Collectors.toList());

        int sum = nums.stream()
                .reduce(0, Integer::sum);

        System.out.printf("Count = %d%n",nums.size());
        System.out.printf("Sum = %d%n",sum);
    }
}
