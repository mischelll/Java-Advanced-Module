package JavaAdvancedExe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> matrix = new ArrayList<>();


        int num = 1;

        for (int row = 0; row < input[0]; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < input[1]; col++) {
                matrix.get(row).add(num);
                num++;
            }
        }

        String command = in.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] data = command.split(" ");

            int rows = Integer.parseInt(data[0]);
            int cols = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int i = rows - radius; i <= rows + radius ; i++) {
                if (inRange(matrix,i,cols) && i != rows){
                    matrix.get(i).remove(cols);
                }
            }

            for (int i = cols + radius; i  >= cols - radius ; i--) {
                if (inRange(matrix,rows,i)){
                    matrix.get(rows).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            command = in.nextLine();
        }

        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }

    static boolean inRange(List<List<Integer>> matrix, int rows, int cols){

        return rows >= 0 && rows < matrix.size() && cols >= 0 && cols < matrix.get(rows).size();
    }



}
