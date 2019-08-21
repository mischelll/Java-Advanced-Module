package JavaAdvancedExe;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> NSX = Arrays.stream(in.nextLine().split(" ")).map(Integer::new).collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(in.nextLine().split(" ")).limit(NSX.get(0)).map(Integer::new).collect(Collectors.toList());

        ArrayDeque stack = new ArrayDeque();
        for (int i = 0; i < numbers.size(); i++) {
            stack.push(numbers.get(i));
        }

        int toRemove = NSX.get(1);


        for (int i = 0; i < toRemove; i++) {
            if (stack.isEmpty()) {
                break;
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            if (stack.contains(NSX.get(2))) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        }

    }
}
