package JavaAdvancedLabs;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] input =
                Arrays.stream(in.nextLine().split(",\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[][] matrix = new int[input[0]][input[1]];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] =
                    Arrays.stream(in.nextLine().split(",\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        int sum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum =
                        matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > sum) {
                    sum = currentSum;
                    startRow = row;
                    startCol = col;
                }

            }
        }

        System.out.println(matrix[startRow][startCol] + " " + matrix[startRow][startCol + 1]);
        System.out.println(matrix[startRow + 1][startCol] + " " + matrix[startRow + 1][startCol + 1]);
        System.out.println(sum);

    }
}
