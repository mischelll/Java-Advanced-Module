package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] rowsCols =
                Arrays.stream(in.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[][] matrix = new int[rowsCols[0]][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] =
                    Arrays.stream(in.nextLine().split(" "))
                            .limit(rowsCols[1])
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        int number = Integer.parseInt(in.nextLine());
        boolean found = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (number == matrix[row][col]){
                    System.out.printf("%d %d\n",row,col);
                    found = true;
                }
            }
        }

        if (!found){
            System.out.println("not found");
        }
    }
}
