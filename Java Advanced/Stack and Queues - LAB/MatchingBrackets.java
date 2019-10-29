package JavaAdvancedLabs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '('){
                stack.push(i);
            }else if (c == ')'){
                int startIndex = stack.pop();
                String exp = expression.substring(startIndex, i + 1);
                System.out.println(exp);
            }
        }
    }
}
