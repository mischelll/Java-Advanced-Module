package JavaAdvancedExe;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] inputs =
                Arrays.stream(in.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (inputs[0] -- > 0){
            int num = Integer.parseInt(in.nextLine());
            firstSet.add(num);

        }

        while (inputs[1]-- > 0){
            int num = Integer.parseInt(in.nextLine());
            secondSet.add(num);
        }

        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)){
                System.out.print(integer + " ");
            }
        }

    }
}
