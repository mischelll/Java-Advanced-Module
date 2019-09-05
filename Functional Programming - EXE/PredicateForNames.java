package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Predicate<Integer> checkLength = length -> length <= n;

        String[] data = bf.readLine().split(" ");

        Arrays.stream(data)
                .filter(x -> checkLength.test(x.length()))
                .forEach(System.out::println);
    }
}
