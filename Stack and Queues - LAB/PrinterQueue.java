package JavaAdvancedLabs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = in.nextLine();

        while (!input.equals("print")){
            if (!input.equals("cancel")){
                queue.offer(input);
            }else {
                if (queue.size() == 0){
                    System.out.println("Printer is on standby");
                }else {

                    System.out.println("Canceled " + queue.pollFirst());
                }
            }

            input = in.nextLine();
        }
        int size = queue.size();
        while (size > 0){
            System.out.println(queue.pollFirst());
            size--;
        }
    }
}
