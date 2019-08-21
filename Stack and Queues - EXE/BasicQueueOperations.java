package JavaAdvancedExe;

import java.util.*;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> NSX = Arrays.stream(in.nextLine().split(" ")).map(Integer::new).collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(in.nextLine().split(" ")).limit(NSX.get(0)).map(Integer::new).collect(Collectors.toList());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numbers.size(); i++) {
            queue.add(numbers.get(i));
        }

        for (int i = 0; i < NSX.get(1); i++) {
            if (!queue.isEmpty()){
                queue.poll();
            }else {
                break;
            }
        }

        if (queue.isEmpty()){
            System.out.println("0");
        }else {
            if (queue.contains(NSX.get(2))){
                System.out.println("true");
            }else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
