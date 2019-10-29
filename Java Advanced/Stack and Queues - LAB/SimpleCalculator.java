package JavaAdvancedLabs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque();

        String[] input = in.nextLine().split(" ");
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }

        while (stack.size() != 1) {
            Integer number1 = Integer.parseInt(stack.pop());
            String op = stack.pop();
            Integer number2 = Integer.parseInt(stack.pop());

            if (op.equals("+")) {
                stack.push(String.valueOf(number1 + number2));
            } else {
                stack.push(String.valueOf(number1 - number2));
            }

        }
        System.out.println(stack.peek());
    }
}
