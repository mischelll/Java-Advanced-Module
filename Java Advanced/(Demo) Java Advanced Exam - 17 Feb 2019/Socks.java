package JavaAdvancedExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);
        Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).forEach(queue::offer);

        List<Integer> pairs = new LinkedList<>();

        while (!stack.isEmpty() && !queue.isEmpty()) {
            int numStack = stack.peek();
            int numQueue = queue.peek();

            if (numStack > numQueue) {
                pairs.add(numStack + numQueue);
                stack.pop();
                queue.poll();
            } else if (numStack < numQueue) {
                stack.pop();
            } else {
                queue.poll();
                stack.push(stack.pop()+1);
            }
        }

        System.out.println(pairs.stream().max(Integer::compareTo).get());
        pairs.stream().forEach(e -> System.out.printf("%d ",e));
    }


}
