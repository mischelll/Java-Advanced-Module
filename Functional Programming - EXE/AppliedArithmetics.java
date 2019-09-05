package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays
                .stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        IntUnaryOperator add = x -> x += 1;
        IntUnaryOperator subtract = x -> x -= 1;
        IntUnaryOperator multiply = x -> x *= 2;

        Function<int[],int[]> add2 = arr -> Arrays.stream(arr).map(x -> ++x).toArray();

        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String command;
        while (!"end".equals(command = bf.readLine())) {
            switch (command) {
                case "add":
                    numbers = add2.apply(numbers);
                    break;
                case "subtract":
                    numbers = Arrays.stream(numbers)
                            .map(subtract)
                            .toArray();
                    break;
                case "multiply":
                    numbers = Arrays.stream(numbers)
                            .map(multiply)
                            .toArray();
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

        }
    }
}
