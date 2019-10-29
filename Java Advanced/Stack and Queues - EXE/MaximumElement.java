package JavaAdvancedExe;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<Long>();

        while (n-- > 0){
            String[] command = in.nextLine().split(" ");
            if (command.length == 1){
                if (command[0].equals("2")){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                }else if (command[0].equals("3")){
                    System.out.println(Collections.max(stack));
                }
            }else {
                long num = Long.parseLong(command[1]);
                stack.push(num);
            }
        }
    }
}
