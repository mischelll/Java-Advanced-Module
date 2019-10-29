package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays
                .stream(bf.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiPredicate<Integer, Integer> divisible = (num, n) -> num % n != 0;

        Consumer<List<Integer>> print = arr -> arr.stream().forEach(e -> System.out.print(e + " "));

        int n = Integer.parseInt(bf.readLine());

        numbers = numbers.stream()
                .filter(x -> divisible.test(x,n))
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        print.accept(numbers);

    }
}
