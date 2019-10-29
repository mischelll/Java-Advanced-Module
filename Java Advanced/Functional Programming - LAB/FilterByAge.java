package JavaAdvancedLabs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BiPredicate<Map.Entry<String, Integer>, Integer> younger = (name, ageLimit) -> name.getValue() <= ageLimit;
        BiPredicate<Map.Entry<String, Integer>, Integer> older = (name, ageLimit) -> name.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName =
                person -> System.out.println(person.getKey());

        Consumer<Map.Entry<String, Integer>> printAge =
                person -> System.out.println(person.getValue());

        Consumer<Map.Entry<String, Integer>> printNameAge =
                person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        Map<String, Integer> nameAge = new LinkedHashMap<>();
        int N = Integer.parseInt(in.nextLine());

        while (N-- > 0) {
            String[] split = in.nextLine().split(", ");

            nameAge.put(split[0], Integer.parseInt(split[1]));

        }

        String condition = in.nextLine();
        int ageLimit = Integer.parseInt(in.nextLine());
        String[] format = in.nextLine().split(" ");

        nameAge.entrySet().stream()
                .filter(person -> condition.equals("younger") ? younger.test(person, ageLimit) :
                        older.test(person, ageLimit))

                .forEach(person -> {
                    if (format.length == 2){
                        printNameAge.accept(person);
                    }else if (format[0].equals("name")){
                        printName.accept(person);
                    }else {
                        printAge.accept(person);
                    }
                });

    }
}
