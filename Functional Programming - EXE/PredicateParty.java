package JavaAdvancedExe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<Integer, Integer> equalLength = Integer::equals;

        List<String> names = Arrays
                .stream(reader.readLine().split(" "))
                .collect(Collectors.toList());

        String command = reader.readLine();
        while (!"Party!".equals(command)) {
            String[] data = command.split(" ");

            if (data[0].endsWith("Remove")) {
                names.removeIf(getPredicate(data[1], data[2]));
            } else {
                List<String> doubles = new ArrayList<>();
                for (String name : names) {
                    if (getPredicate(data[1], data[2]).test(name)) {
                        doubles.add(name);
                    }
                }
                names.addAll(doubles);
            }

            command = reader.readLine();
        }

        Collections.sort(names);

        if (!names.isEmpty()) {
            System.out.println(String.join(", ", names) + " are going to the party!");

        }else {
            System.out.println("Nobody is going to the party!");
        }

    }

    static Predicate<String> getPredicate(String type, String parameter) {
        if (type.equals("StartsWith")) {
            return x -> x.startsWith(parameter);
        } else if (type.equals("EndsWith")) {
            return x -> x.endsWith(parameter);
        } else {
            return x -> x.length() == Integer.parseInt(parameter);
        }
    }
}
