package JavaAdvancedExe;

import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Set<String> elements = new TreeSet<>();

        while (n-- > 0) {
            List<String> input =
                    Arrays.stream(in.nextLine().split(" "))
                            .collect(Collectors.toList());

            elements.addAll(input);

        }

        for (String s : elements) {
            System.out.print(s + " ");
        }

    }
}
