package JavaAdvancedExe;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int mainDiagonal = sumMainDiagonal(matrix);
        int otherDiagonal = sumOtherDiagonal(matrix);

        int diff = Math.abs(mainDiagonal - otherDiagonal);
        System.out.println(diff);
    }

    static int sumMainDiagonal(int[][] matrix){
        int main = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    main += matrix[row][col];
                }

            }
        }

        return main;
    }

    static int sumOtherDiagonal(int[][] matrix){
        int other = 0;
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col <= matrix[row].length - 1){
            other += matrix[row][col];
            row--;
            col++;
        }

        return other;
    }

}
