package JavaAdvancedExe;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split("");

        ArrayDeque<String> stack = new ArrayDeque<>();

        boolean balanced = true;
        if (input.length < 2){
            System.out.println("NO");
            return;
        }
        for (String s: input) {
            if (s.equals("(")){
                stack.push(s);
            }
            if (s.equals("{")){
                stack.push(s);
            }
            if (s.equals("[")){
                stack.push(s);
            }

            if (s.equals(")")){
                if (stack.isEmpty() || !stack.pop().equals("(")){
                    balanced = false;
                }
            }
            if (s.equals("}")){
                if (stack.isEmpty() || !stack.pop().equals("{")){
                    balanced = false;
                }
            }
            if (s.equals("]")){
                if (stack.isEmpty() || !stack.pop().equals("[")){
                    balanced = false;
                }
            }
        }
        if (balanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
