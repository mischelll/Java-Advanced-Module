package JavaAdvancedExe;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> list = Arrays.stream(in.nextLine().split(" ")).map(Integer::new).collect(Collectors.toList());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            int k = list.get(i);
            stack.push(k);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
