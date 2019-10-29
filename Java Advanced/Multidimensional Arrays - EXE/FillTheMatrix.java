package JavaAdvancedExe;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(", ");

        int N = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[N][N];

        if (pattern.equals("A")) {
            patternA(pattern, matrix);
        } else {
            patternB(pattern, matrix);
        }


    }

    static void patternA(String pattern, int[][] matrix) {
        int value = 1;
        int columns = 0;

        while (columns < matrix.length) {

            for (int row = 0; row < matrix.length; row++) {
                matrix[row][columns] = value;
                value++;
            }

            columns++;
        }

        printMatrix(matrix);

    }

    static void patternB(String pattern, int[][] matrix) {
        int value = 1;
        int columns = 0;

        while (columns < matrix.length) {

            if (columns % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][columns] = value;
                    value++;
                }

            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][columns] = value;
                    value++;
                }
            }

            columns++;
        }

        printMatrix(matrix);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", ""));
        }
    }

}
