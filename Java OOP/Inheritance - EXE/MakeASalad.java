package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MakeASalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> vegetables = new ArrayDeque<>();//queue
        ArrayDeque<Integer> salads = new ArrayDeque<>();//stack

        Arrays.stream(reader.readLine().split("\\s+")).forEach(vegetables::offer);
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(salads::push);

        List<Integer> ready = new LinkedList<>();
        int remainder = 0;

        while (!vegetables.isEmpty() && !salads.isEmpty()) {
            int salad = salads.pop();
            String vegetable = vegetables.poll();
            switch (vegetable) {
                case "tomato":
                    int value = 80;
                    if (salad > value) {
                        salads.push(salad - value);
                        remainder += value;
                    } else {
                        ready.add(salad + remainder);
                        remainder = 0;
                    }
                    break;
                case "carrot":
                    value = 136;
                    if (salad > value) {
                        salads.push(salad - value);
                        remainder += value;
                    } else {
                        ready.add(salad + remainder);
                        remainder = 0;
                    }
                    break;
                case "lettuce":
                    value = 109;
                    if (salad > value) {
                        salads.push(salad - value);
                        remainder += value;
                    } else {
                        ready.add(salad + remainder);
                        remainder = 0;
                    }
                    break;
                case "potato":
                    value = 215;
                    if (salad > value) {
                        salads.push(salad - value);
                        remainder += value;
                    } else {
                        ready.add(salad + remainder);
                        remainder = 0;
                    }
                    break;
            }
        }

        if (remainder != 0){
            ready.add( remainder + salads.pop());
        }

        List<String> list = ready
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(String.join(" ", list));

        if (!salads.isEmpty()) {
            List<String> list2 = salads
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            System.out.println(String.join(" ", list2));
        }

        if (!vegetables.isEmpty()) {
            System.out.println(String.join(" ", vegetables));
        }
    }
}
