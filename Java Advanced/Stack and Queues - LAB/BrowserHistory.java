package JavaAdvancedLabs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = in.nextLine();
        while (!input.equals("Home")) {
            if (!input.equals("back")) {
                stack.push(input);
                System.out.println(stack.peek());
            } else {

                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());
                }else {
                    System.out.println("no previous URLs");
                }



            }

            input = in.nextLine();
        }

    }
}
