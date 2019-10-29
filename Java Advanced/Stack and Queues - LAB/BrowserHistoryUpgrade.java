package JavaAdvancedLabs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();


        String input = in.nextLine();
        while (!input.equals("Home")) {

            if (input.equals("forward")) {
                if (queue.size() > 0){
                    System.out.println(queue.peek());
                    stack.push(queue.poll());
                }else {
                    System.out.println("no next URLs");
                }
            } else if (input.equals("back")) {

                if (stack.size() > 1) {
                    queue.addFirst(stack.pop());
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else {
                stack.push(input);
                queue.clear();
                System.out.println(stack.peek());
            }

            input = in.nextLine();
        }

    }
}
