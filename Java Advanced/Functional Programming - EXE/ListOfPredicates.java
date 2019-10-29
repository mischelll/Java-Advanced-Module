package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int upperBoundary = Integer.parseInt(bf.readLine());
        List<Integer> sequence = Arrays
                .stream(bf.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> range = IntStream.rangeClosed(1, upperBoundary)
                .boxed()
                .collect(Collectors.toList());

        Predicate<Integer> check = num -> {
            for (Integer integer :sequence) {
                if (integer == 0){
                    continue;
                }

                if (num % integer != 0){
                    return false;
                }
            }
            return true;
        };

        for (Integer x : range) {
            if(check.test(x)){
                System.out.printf("%d ",x);
            }
        }




    }
}
