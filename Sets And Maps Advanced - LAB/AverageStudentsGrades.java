package JavaAdvancedLabs;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, List<Double>> strudentGrade = new TreeMap<>();

        int n = Integer.parseInt(in.nextLine());

        while (n-- > 0) {
            String[] data = in.nextLine().split(" ");

            String name = data[0];
            double grade = Double.parseDouble(data[1]);

            strudentGrade.putIfAbsent(name, new LinkedList<>());
            strudentGrade.get(name).add(grade);
        }

        strudentGrade.entrySet().stream().forEach(e -> {
            System.out.printf("%s -> ",e.getKey());
            double sum = 0;
            for (Double aDouble : e.getValue()) {
                sum += aDouble;
                System.out.printf("%.2f ",aDouble);
            }
            System.out.printf("(avg: %.2f)\n",sum/e.getValue().size());
        });

    }
}
