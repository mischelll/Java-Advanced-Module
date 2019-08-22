package JavaAdvancedLabs;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] numbers = in.nextLine().split(",\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
                sum += matrix[row][col];
            }
        }

        System.out.printf("%d\n%d\n%d", rows, cols, sum);

    }
}
