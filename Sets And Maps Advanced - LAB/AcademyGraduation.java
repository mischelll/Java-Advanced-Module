package JavaAdvancedLabs;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        Map<String, List<Double>> nameGrades = new TreeMap<>();

        while (n-- > 0) {
            String name = in.nextLine();
            List<Double> list = Arrays.stream(in.nextLine()
                    .split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            nameGrades.putIfAbsent(name, new LinkedList<>());
            nameGrades.get(name).addAll(list);

        }

        nameGrades.entrySet().stream().forEach(e -> {
           double average = 0;
            for (Double aDouble : e.getValue()) {
                average += aDouble;
            }
            average /= e.getValue().size();

            System.out.printf("%s is graduated with %s\n",e.getKey(),average);
        });

    }
}
