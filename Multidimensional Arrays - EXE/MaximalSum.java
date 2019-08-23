package JavaAdvancedExe;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(" ");
        int rowsCount = Integer.parseInt(input[0]);
        int colsCount = Integer.parseInt(input[1]);

        int[][] matrix = new int[rowsCount][colsCount];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length- 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum =
                        matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                                + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col+1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum){
                    maxSum = currentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.printf("Sum = %d\n",maxSum);
        for (int row = startRow ; row < startRow + 3 ; row++) {
            for (int col = startCol  ; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

}
