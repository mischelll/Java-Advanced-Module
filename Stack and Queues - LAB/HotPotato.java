package JavaAdvancedLabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> children = Arrays.stream(in.nextLine().split(" ")).collect(Collectors.toList());
        int n = Integer.parseInt(in.nextLine());
        int counter = 0;
        List<Integer> indexes = new ArrayList<>();

        boolean toContinue = true;

        while (toContinue) {
            for (int i = 0; i < children.size(); i++) {
                if (!indexes.contains(i)) {
                    if (indexes.size() + 1 == children.size()){
                        System.out.printf("Last is %s",children.get(i));
                        toContinue = false;
                        break;
                    }
                    counter++;
                    if (counter == n){
                        System.out.printf("Removed %s\n",children.get(i));
                        indexes.add(i);
                        counter = 0;

                    }
                }
            }
        }



    }
}
